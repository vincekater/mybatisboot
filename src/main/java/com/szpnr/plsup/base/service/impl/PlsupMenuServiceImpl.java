package com.szpnr.plsup.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szhome.security.ext.UserInfo;
import com.szpnr.plsup.base.entity.PlsupMenu;
import com.szpnr.plsup.base.mapper.PlsupMenuMapper;
import com.szpnr.plsup.base.service.IPlsupMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dengsy
 * @since 2019-08-09
 */
@Service
public class PlsupMenuServiceImpl extends ServiceImpl<PlsupMenuMapper, PlsupMenu> implements IPlsupMenuService {

    public List<PlsupMenu> getMenuByUserInfo(UserInfo userInfo){
        QueryWrapper<PlsupMenu> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().and(obj->
//                obj.eq(PlsupMenu::getParentCode,"parentCode")
//        );
        queryWrapper.orderByAsc("PARENT_ID","SEQ");
        //criteria.andPermCodeEqualTo("");
        //example.setOrderByClause("PARENT_ID ASC,SEQ ASC");//设置排序字段，排序字段用数据库字段
        //List<PlsupMenu> menus =  getBaseMapper().selectList(queryWrapper);
        List<PlsupMenu> menus = list(queryWrapper);
        List<PlsupMenu> userMenus = new ArrayList<>();
        //整理菜单，设置主菜单和子菜单,只支持两级菜单
        for (PlsupMenu plsupMenu : menus) {
            if(plsupMenu.getParentId()==0){
                if(userMenus.size()==0){//第一个菜单默认展开
                    plsupMenu.setExpanded(true);
                }
                if(!StringUtils.isEmpty(plsupMenu.getPermCode())
                        && userInfo.getUserPermList().contains(plsupMenu.getPermCode())){
                    userMenus.add(plsupMenu);
                }else if(StringUtils.isEmpty(plsupMenu.getPermCode())) {//权限码为空的菜单作为公共菜单
                    userMenus.add(plsupMenu);
                }
            }else{
                for (PlsupMenu userMenu : userMenus) {
                    if(userMenu.getMenuId() == plsupMenu.getParentId()){
                        if(userMenu.getSubMenu()==null){
                            List<PlsupMenu> subMenu  = new ArrayList<>();
                            userMenu.setSubMenu(subMenu);
                        }
                        if(!StringUtils.isEmpty(plsupMenu.getPermCode())
                                && userInfo.getUserPermList().contains(plsupMenu.getPermCode())){
                            userMenu.getSubMenu().add(plsupMenu);
                        }else if(StringUtils.isEmpty(plsupMenu.getPermCode())) {//权限码为空的菜单作为公共菜单
                            userMenu.getSubMenu().add(plsupMenu);
                        }
                    }
                }
            }
        }
//        menus.forEach(plsupMenu -> {
//            //如果菜单权限码不为空，则判断userInfo权限列表是否包含了菜单的权限码
//            if(!StringUtils.isEmpty(plsupMenu.getPermCode())
//                    && userInfo.getUserPermList().contains(plsupMenu.getPermCode())){
//                userMenus.add(plsupMenu);
//            }else if(StringUtils.isEmpty(plsupMenu.getPermCode())) {//权限码为空的菜单作为公共菜单
//                userMenus.add(plsupMenu);
//            }
//        });
        return userMenus;
    }


    public Page<PlsupMenu> list(Map<String,String> param){
        //Map<String,Object> result = new HashMap<String,Object>();
        int currentPage = Integer.parseInt(param.get("page"));
        int pagesize = Integer.parseInt(param.get("pagesize"));
        QueryWrapper<PlsupMenu> queryWrapper = new QueryWrapper<>();

        if(!StringUtils.isEmpty(param.get("title")))  queryWrapper.and(i-> i.like("title",param.get("title")));
        if(!StringUtils.isEmpty(param.get("permCode"))) queryWrapper.and(i-> i.like("permCode",param.get("permCode")));
        if(!StringUtils.isEmpty(param.get("path"))) queryWrapper.and(i-> i.like("path",param.get("path")));
//        queryWrapper.lambda().and(obj->{
//            if(!StringUtils.isEmpty(param.get("title"))) obj.like(PlsupMenu::getTitle,"title");
//            if(!StringUtils.isEmpty(param.get("permCode"))) obj.like(PlsupMenu::getPermCode,"permCode");
//            if(!StringUtils.isEmpty(param.get("path"))) obj.like(PlsupMenu::getPath,"path");
//            return obj;
//        });
        queryWrapper.orderByAsc("PARENT_ID","SEQ");//设置排序字段，排序字段用数据库字段
        Page<PlsupMenu> ipage = new Page<>(currentPage,pagesize);
//        ipage.setCurrent(currentPage);
//        ipage.setSize(pagesize);
        page(ipage,queryWrapper);
        //List<PlsupMenu> menus
        //getBaseMapper().selectPage(ipage,queryWrapper);

        return ipage;
    }
}
