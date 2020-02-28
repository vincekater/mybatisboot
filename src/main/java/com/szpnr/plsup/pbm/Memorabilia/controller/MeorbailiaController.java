package com.szpnr.plsup.pbm.Memorabilia.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szhome.security.ext.UserInfo;
import com.szpnr.plsup.common.controller.BaseController;
import com.szpnr.plsup.common.controller.ResponseResult;
import com.szpnr.plsup.pbm.Memorabilia.entity.PlsupEventSummary;
import com.szpnr.plsup.pbm.Memorabilia.service.impl.PluspEvemtSummaryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "meorabilia")
public class MeorbailiaController extends BaseController {

    @Autowired
    private PluspEvemtSummaryImpl summaryService;

    @GetMapping(path = "list")
    public ResponseResult list(@RequestParam(defaultValue = "1") Long current, @RequestParam(defaultValue = "20") Long size) {
        ResponseResult result = new ResponseResult();
        Page<PlsupEventSummary> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        page.setOrders(Collections.singletonList(OrderItem.asc("EVENT_ID")));
        IPage<PlsupEventSummary> iPage = summaryService.page(page, Wrappers.emptyWrapper());
        return result.success(iPage);
    }

    @PostMapping(path = "save")
    public ResponseResult add(@RequestBody PlsupEventSummary eventSummary) {
        ResponseResult result = new ResponseResult();
        eventSummary.setEventSetp("审核");
        boolean success = summaryService.saveOrUpdate(eventSummary);
        if (success) {
            result.success();
        } else {
            result.failure("saveOrUpdate failed");
        }
        return result;
    }

    @DeleteMapping(path = "delete")
    public ResponseResult delete(@RequestParam String id) {
        ResponseResult result = new ResponseResult();
        boolean success = summaryService.removeById(id);
        if (success) {
            result.success();
        } else {
            result.failure();
        }
        return result;
    }

    @GetMapping(path = "item")
    public ResponseResult item(@RequestParam Long id) {
        ResponseResult result = new ResponseResult();
        PlsupEventSummary summary = summaryService.getById(id);
        return result.success(summary);
    }

    @PostMapping(path = "do")
    public ResponseResult doProcess(@RequestBody Map<String, String> params) {
        Long id = Long.valueOf(params.get("id"));
        String pass = params.get("pass");
        ResponseResult result = new ResponseResult();
        summaryService.doSetp(id, pass);
        return result.success();
    }

    @GetMapping(path = "show")
    public ResponseResult doShow(@RequestParam String date) throws ParseException {
        ResponseResult result = new ResponseResult();
        List<PlsupEventSummary> show = summaryService.findShow(date);
        return result.success(show);
    }

}
