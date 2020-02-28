package com.szpnr.plsup.pbm.Memorabilia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.szpnr.plsup.pbm.Memorabilia.entity.PlsupEventSummary;
import com.szpnr.plsup.pbm.Memorabilia.mapper.PlsupEventSumaryMapper;

import java.util.List;
import java.util.Map;

public interface PlsupEventSummaryService {
    boolean doSetp(Long id, String pass);

    List<PlsupEventSummary> findShow(String date);
}
