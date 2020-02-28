import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szpnr.plsup.PlsupApplication;
import com.szpnr.plsup.base.entity.PlsupMenu;
import com.szpnr.plsup.base.entity.SecUsers;
import com.szpnr.plsup.base.mapper.PlsupLocationMapper;
import com.szpnr.plsup.base.entity.PlsupLocation;
import com.szpnr.plsup.base.mapper.PlsupMenuMapper;
import com.szpnr.plsup.base.service.ISecUsersService;
import com.szpnr.plsup.common.controller.ResponseResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PlsupApplication.class)
@MapperScan("com.szpnr.plsup.*.mapper,com.szpnr.plsup.*.*.mapper")
//@MapperScan("com.szpnr.plsup.pbm.casereg.mapper")
public class MybatisPlusTest {
    @Resource
    private PlsupLocationMapper locationMapper;

    @Resource
    private PlsupMenuMapper plsupMenuMapper;

    @Autowired
    public ISecUsersService iSecUsersService;

    @Test
    public void testSelect() {

        System.out.println(("----- selectAll method test ------"));
        //单表分页查询测试
        QueryWrapper<PlsupLocation> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().and(obj->{
            obj.eq(PlsupLocation::getParentCode,"LH");
            obj.apply("location_code={0}","LH_QINGSHUIHE");//拼接sql测试,可执行函数
            return obj;
        });
        Page<PlsupLocation> ipage = new Page<>(1,5);
        locationMapper.selectPage(ipage,queryWrapper);
        System.out.println(ipage.getRecords().size());
        System.out.println(JSON.toJSONString(new ResponseResult().success(ipage)));
        //自定义sql,多表联合查询分页测试
        QueryWrapper<PlsupLocation> customWrapper = new QueryWrapper<>();
        customWrapper.lambda().and(obj->{
            obj.eq(PlsupLocation::getParentCode,"LH");
            obj.apply("l.location_code={0}","LH_QINGSHUIHE");//拼接sql测试,可执行函数
            return obj;
        });
        Page<Map<String,Object>> mapPage = new Page<>(1,5);
        mapPage = locationMapper.listLocations(mapPage,customWrapper);
        System.out.println(mapPage.getTotal());
        System.out.println(JSON.toJSONString(mapPage));

//        PlsupMenu menu = new PlsupMenu();
//        menu.setTitle("菜单测试");
//        plsupMenuMapper.insert(menu);
        //locationMapper.selectMaps();
//        List<PlsupLocation> userList = locationMapper.selectList(queryWrapper);
//        System.out.println(userList.size());
         //Assert.assertEquals(5, userList.size());
        //userList.forEach(System.out::println);


//        QueryWrapper<SecUsers> queryWrapper2 = new QueryWrapper<>();
//        queryWrapper2.eq("account","dengsy");
//        List<SecUsers> secUsers = iSecUsersService.list(queryWrapper2);
//        System.out.println(secUsers.size());
    }


}
