<template>
    <el-card>
        <div class="container">
            <div class="table">
                <div class="handle-box">
                    <el-form ref="form" :model="queryForm" label-position="left" :inline="true">
                        <el-row>
                            <el-col :span="5">
                                <el-form-item label="菜单名称" >
                                    <el-input v-model="queryForm.title" class="handle-input" style="width: 180px;"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="4">
                                <el-form-item label="访问路径" >
                                    <el-input v-model="queryForm.permCode" class="handle-input" style="width: 180px;"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="4">
                                <el-form-item label="权限码" >
                                    <el-input v-model="queryForm.permCode" class="handle-input" style="width: 180px;"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span="5">&nbsp;&nbsp;&nbsp;&nbsp;</el-col>
                            <el-col :span="4">
                                <el-button type="primary" icon="search" @click="getData">搜索</el-button>
                                <el-button type="primary" @click="add">新增</el-button>
                            </el-col>
                            <el-col></el-col>
                        </el-row>
                    </el-form>
                </div>
                <el-table :data="tableData" border stripe style="width: 100%" v-loading="loading"
                          element-loading-text="加载中..."
                          element-loading-spinner="el-icon-loading">
                    <el-table-column prop="menuId" label="菜单ID" sortable></el-table-column>
                    <el-table-column prop="parentId" label="父菜单ID" sortable>
                    </el-table-column>
                    <el-table-column prop="title" label="菜单名称" >
                    </el-table-column>
                    <el-table-column prop="path" label="访问路径" >
                    </el-table-column>
                    <el-table-column prop="iconpath" label="菜单图标">
                    </el-table-column>
                    <el-table-column prop="permCode" label="权限码" >
                    </el-table-column>
                    <el-table-column prop="seq" label="排序序号">
                    </el-table-column>
                    <el-table-column prop="component" label="菜单组件路径" >
                    </el-table-column>
                    <el-table-column label="操作" width="160">
                        <template slot-scope="scope">
                            <el-button size="mini" type="primary" @click="handleEdit(scope.$index, scope.row,true)">查看</el-button>
                            <el-button size="mini" v-show="scope.row.status==null" type="primary" @click="handleEdit(scope.$index, scope.row,false)">编辑</el-button>
                        </template>
                    </el-table-column>
                </el-table>

                <div class="pagination">
                    <el-pagination
                            @current-change="handleCurrentChange"
                            @size-change="handleSizeChange"
                            :page-size="queryForm.pagesize"
                            layout="total, sizes, prev, pager, next, jumper"
                            :total="total">
                    </el-pagination>
                </div>
                <MenuEdit ref="menuEdit" @refreshList="getData"></MenuEdit>
            </div>
        </div>
    </el-card>
</template>

<script>
    import MenuEdit from './MenuEdit'
    // import {ComboDept} from '../../../plui3/index'

    export default {
        data() {
            return {
                url: '/plsupMenu/list',
                tableData: [],
                total: 0,
                editVisible: false,
                rules: {},
                queryForm: {
                    page: 1,
                    pagesize:10,
                    path:'',
                    title: '',
                    permCode: '',
                    userId:sessionStorage.getItem('userId')
                },
                loading: true
            }
        },
        created() {
            this.getData();
        },
        computed: {
            data() {
                return this.tableData;
            }
        },
        components: {
            MenuEdit
        },
        methods: {
            handleCurrentChange(val) {
                this.queryForm.page = val;
                this.getData();
            },
            // 获取数据
            getData() {
                this.$axios.post(this.url, this.queryForm).then((res) => {
                    this.tableData = res.data.data.records;
                    this.total = res.data.data.total;
                    this.loading = false;
                })
            },
            //新增
            add(){
                this.$refs.menuEdit.open(true,null,false);
            },
            handleEdit(index, row,isView) {
                this.$axios.post("/plsupMenu/get", {"menuId":this.tableData[index].menuId}).then((res) => {
                    if (res.data.meta.success) {
                        const item = res.data.data;
                        this.$refs.menuEdit.open(true,item,isView);
                    } else {
                        this.$message.error(res.data.meta.message);
                    }
                });
            },
            handleSizeChange(val) {
                this.queryForm.pagesize = val;
            }
        },
        activated:function () {
            this.getData();
        }

    }
</script>

<style scoped>
    .handle-box {
        margin-bottom: 20px;
    }

    .handle-input {
        width: 300px;
        display: inline-block;
    }
</style>
