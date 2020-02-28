package com.szpnr.plsup.pbm.Memorabilia.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.szhome.security.ext.UserInfo;
import com.szpnr.plsup.pbm.Memorabilia.entity.PlsupEventSummary;
import com.szpnr.plsup.pbm.Memorabilia.mapper.PlsupEventSumaryMapper;
import com.szpnr.plsup.pbm.Memorabilia.service.PlsupEventSummaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class PluspEvemtSummaryImpl extends ServiceImpl<PlsupEventSumaryMapper, PlsupEventSummary> implements PlsupEventSummaryService {

    @Override
    public boolean doSetp(Long id, String pass) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        Objects.requireNonNull(userInfo);
        PlsupEventSummary summary = this.getById(id);
        if (summary != null && "Y".equals(pass)) {
            String eventSetp = summary.getEventSetp();
            if ("审核".equals(eventSetp)) {
                summary.setEventSetp("发布");
                summary.setEventReviewer(userInfo.getUserName());
                summary.setEventReviewerid(userInfo.getUserID());
            } else if ("发布".equals(eventSetp)) {
                summary.setEventPublisher(userInfo.getUserName());
                summary.setEventPublisherid(userInfo.getUserID());
                summary.setEventSetp("完结");
                summary.setEventFinsh(1);
            }
            updateById(summary);
        } else {
            summary.setEventFinsh(1);
            updateById(summary);
        }
        return true;
    }

    @Override
    public List<PlsupEventSummary> findShow(String date) {
        List summarys = baseMapper.findByMonth(date);
        return summarys;
    }
}
