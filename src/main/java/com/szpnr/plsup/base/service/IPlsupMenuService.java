package com.szpnr.plsup.base.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szhome.security.ext.UserInfo;
import com.szpnr.plsup.base.entity.PlsupMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dengsy
 * @since 2019-08-09
 */
public interface IPlsupMenuService extends IService<PlsupMenu> {
    public List<PlsupMenu> getMenuByUserInfo(UserInfo userInfo);
    public Page<PlsupMenu> list(Map<String,String> param);
}
