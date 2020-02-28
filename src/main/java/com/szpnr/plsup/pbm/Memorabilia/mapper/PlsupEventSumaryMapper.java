package com.szpnr.plsup.pbm.Memorabilia.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.szpnr.plsup.pbm.Memorabilia.entity.PlsupEventSummary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PlsupEventSumaryMapper extends BaseMapper<PlsupEventSummary> {

    @Select({"select * from PLSUP_EVENT_SUMMARY  where  to_char(EVENT_DATE,'yyyymm') =  #{date}"})
    List<PlsupEventSummary> findByMonth(@Param("date") String date);
}
