package com.szpnr.plsup.pbm.Memorabilia.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@KeySequence(value="SEQ_PLSUP_DEFAULT",clazz = Long.class)
@TableName("PLSUP_EVENT_SUMMARY")
public class PlsupEventSummary  {

    @TableId(type = IdType.INPUT)
    private Long eventId;
    private Date eventDate;
    private String eventPlace;
    private String eventCompere;
    private String eventType;
    private String eventTier;
    private String eventTheme;
    private String eventContent;
    private String eventBiztype;
    private String eventSubmitter;
    private String eventSubmitterid;
    private String eventReviewer;
    private String eventReviewerid;
    private String eventPublisher;
    private String eventPublisherid;
    private Integer eventFinsh;
    private String eventSetp;

}
