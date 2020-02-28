package com.szpnr.plsup.base.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szpnr.plsup.base.entity.PlsupLocation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 区域设置表 Mapper 接口
 * </p>
 *
 * @author dengsy
 * @since 2019-08-09
 */
public interface PlsupLocationMapper extends BaseMapper<PlsupLocation> {

    /**
     * 自定义sql,使用查询条件构造器
     * 注解@Select的sql中加入  ${ew.customSqlSegment}
     * 参数查询构造器Wrapper前加入注解 @Param(Constants.WRAPPER)
     *
     *         QueryWrapper<PlsupLocation> customWrapper = new QueryWrapper<>();
     *         customWrapper.lambda().and(obj->{
     *             obj.eq(PlsupLocation::getParentCode,"LH");//查询plsup_location的parent_code值为"LH"的数据
     *             obj.apply("l.location_code={0}","LH_QINGSHUIHE");//使用具体字段拼接sql测试,可以使用to_date等函数
     *             return obj;
     *         });
     *         Page<Map<String,Object>> mapPage = new Page<>(1,5);
     *         mapPage = locationMapper.listLocations(mapPage,customWrapper);
     *         System.out.println(mapPage.getTotal());
     *         System.out.println(JSON.toJSONString(mapPage));
     *
     */
    @Select("select l.location_id,l.location_name,l.location_code,l.parent_code,ll.group_id,ll.group_name " +
            "from plsup_location l join plsup_group_location  ll " +
            "on l.location_code=ll.location_code ${ew.customSqlSegment} ")
    public Page<Map<String,Object>> listLocations(IPage<Map<String,Object>> mapIPage,
                                                  @Param(Constants.WRAPPER) QueryWrapper<PlsupLocation> queryWrapper);
}
