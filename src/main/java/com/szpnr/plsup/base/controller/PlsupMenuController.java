package com.szpnr.plsup.base.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szhome.security.ext.UserInfo;
import com.szpnr.plsup.base.entity.PlsupMenu;
import com.szpnr.plsup.base.service.IPlsupMenuService;
import com.szpnr.plsup.common.controller.BaseController;
import com.szpnr.plsup.common.controller.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("plsupMenu")
public class PlsupMenuController extends BaseController {
    @Autowired
    IPlsupMenuService plsupMenuService;

    @ApiOperation(value="获取用户菜单", notes="获取用户菜单")
    @RequestMapping(value="getMenus",method = RequestMethod.GET)
    public ResponseResult getMenus(){
        if(getSession().getAttribute("userInfo")==null){
            return new ResponseResult().failure("用户Session失效！");
        }else{
            UserInfo userInfo = (UserInfo)getSession().getAttribute("userInfo");
            List<PlsupMenu> list= plsupMenuService.getMenuByUserInfo(userInfo);
            return new ResponseResult().success(list);
        }
    }

    @ApiOperation(value="获取用户菜单", notes="获取用户菜单")
    @RequestMapping(value="getMenusRouter",method = RequestMethod.GET)
    public ResponseResult getMenusRouter(){
            QueryWrapper<PlsupMenu> queryWrapper = new QueryWrapper<>();
            queryWrapper.isNotNull("component");
            List<PlsupMenu> list= plsupMenuService.list(queryWrapper);
            return new ResponseResult().success(list);

    }


    @ApiOperation(value="管理菜单，获取菜单列表", notes="管理菜单，获取菜单列表")
    @RequestMapping(value="list",method = RequestMethod.POST)
    public ResponseResult list(@RequestBody Map<String,String> param){
        Page<PlsupMenu> page =  plsupMenuService.list(param);
        return new ResponseResult().success(page);
    }


    @ApiOperation(value="获取菜单信息", notes="获取菜单信息")
    @RequestMapping(value="get",method = RequestMethod.POST)
    public ResponseResult get(@RequestBody Map<String,String> param){
        PlsupMenu plsupMenu =  plsupMenuService.getById(Long.parseLong(param.get("menuId")));
//        plsupMenuService.getOne();
        return new ResponseResult().success(plsupMenu);
    }

    @ApiOperation(value="获取菜单信息", notes="获取菜单信息")
    @RequestMapping(value="save",method = RequestMethod.POST)
    public ResponseResult save(@RequestBody PlsupMenu plsupMenu){
        plsupMenuService.saveOrUpdate(plsupMenu);
        return new ResponseResult().success(plsupMenu);
    }
}
