<template>
    <el-dialog id="dialog" title="菜单配置" :close-on-click-modal="false" :append-to-body="true"
               :visible.sync="editVisible" width="80%" :fullscreen="true" @close="closeDialog">
        <el-form ref="form" :model="form" :rules="rules" label-position="right" label-width="120px" :inline="true">
            <el-row>
                <el-col :span="12">
                    <el-form-item label="菜单名称" size="mini">
                        <el-input v-model="form.title" v-bind:readonly="readonly" size="mini" prop="title"
                                  style="width:300px"></el-input>
                        <el-input v-model="form.menuId" style="display: none;"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="父菜单ID">
                        <el-input v-model="form.parentId" v-bind:readonly="readonly" size="mini" prop="title"
                                  style="width:100px"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="访问路径" prop="type" size="mini">
                        <el-input v-model="form.path" v-bind:readonly="readonly" size="mini"  style="width:300px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="菜单图标" prop="type" size="mini">
                        <el-input v-model="form.iconpath" v-bind:readonly="readonly" size="mini"  style="width:300px"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="权限码" prop="type" size="mini">
                        <el-input v-model="form.permCode" v-bind:readonly="readonly" size="mini"  style="width:300px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="排序序号" prop="type" size="mini">
                        <el-input v-model="form.seq" v-bind:readonly="readonly" size="mini"  style="width:300px"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="菜单组件路径" prop="type" size="mini">
                        <el-input v-model="form.component" v-bind:readonly="readonly" size="mini"  style="width:300px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="备注" prop="type" size="mini">
                        <el-input v-model="form.remark" v-bind:readonly="readonly" size="mini"  style="width:300px"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
      <el-button @click="closeDialog">取 消</el-button>
      <el-button type="primary" @click="saveEdit" v-if="!readonly">确 定</el-button>
    </span>
    </el-dialog>
</template>
<script>
    export default {
        data() {
            return {
                editVisible: false,
                readonly: true,
                loading: true,
                form: {
                    menuId: "",
                    parentId: "0",
                    title: "",
                    path: "",
                    iconpath: "",
                    permCode: "",
                    seq: "",
                    component: "",
                    remark: "",
                },
                rules: {
                    title: [
                        {required: true, message: "标题", trigger: "blur"},
                        {
                            min: 2,
                            max: 200,
                            message: "长度在 2 到200 个字符",
                            trigger: "blur"
                        }
                    ],
                    parentName: [
                        {required: true, message: "目录", trigger: "blur"},
                        {min: 2, max: 20, message: "长度在 2 到200 个字符", trigger: "blur"}
                    ]
                }
            };
        },
        methods: {
            saveEdit() {
                this.$refs.form.validate(valid => {
                    if (valid) {
                        this.$axios
                            .post("/plsupMenu/save", this.form)
                            .then(res => {
                                if (res.data.meta.success) {
                                    if (res.data.data.tempid) {
                                        this.$message({
                                            message: "文档基本信息保存成功，正在保存文档模板内容!",
                                            type: "success"
                                        });
                                        this.saveDocContent();
                                    }
                                    // this.editVisible = false;
                                    // this.$emit("refreshList");
                                } else {
                                    this.$message.error(res.data.meta.message);
                                }
                            })
                            .catch(function (error) {
                            });
                    } else {
                        //console.log("error submit!!");
                        return false;
                    }
                });
            },
            open(editVisible, form, editflag) {
                this.loading = true;
                this.editVisible = editVisible;
                if (form != null) {
                    this.form = form;
                }
                this.readonly = editflag;
                if (this.$refs.form !== undefined) {
                    this.$refs.form.resetFields();
                }
            },
            closeDialog(){
                this.editVisible = false;
            },
            username() {
                let username = sessionStorage.getItem("username");
                return username ? username : this.name;
            }
        },
        destroyed: function () {
            // try {} catch (e) {}
        }
    };
</script>
