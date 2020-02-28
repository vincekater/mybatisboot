package com.szpnr.plsup.base.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.szpnr.plsup.base.mapper.PlsupLocationMapper;
import com.szpnr.plsup.base.entity.PlsupLocation;
import com.szpnr.plsup.common.controller.BaseController;
import com.szpnr.plsup.common.controller.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("location")
public class PlsupLocationController extends BaseController {


//    @ApiOperation(value="获取plsupLocation详细信息", notes="根据url的id来获取plsupLocation详细信息")
//    @ApiImplicitParam(name = "locationId", value = "locationId", required = true, dataType = "Long", paramType = "path")
//    @RequestMapping(value="getPlsupLocation/{locationId}",method = RequestMethod.GET)
//    ResponseResult getPlsupLocationById(@PathVariable("locationId") Long locationId) {
//        PlsupLocation location = plsupLocationMapper.selectByPrimaryKey(locationId);
//        //System.out.println(location);
//        System.out.println(getHttpServletRequest().getRequestURI());
//        return new ResponseResult().success(location);
//    }

    @ApiOperation(value="根据url的parentCode获取下一级plsupLocation列表", notes="根据url的parentCode获取下一级plsupLocation列表")
    @ApiImplicitParam(name = "parentCode", value = "parentCode", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value="getChildrenLocations/{parentCode}",method = RequestMethod.GET)
    ResponseResult getChildrenPlsupLocationByParanCode(@PathVariable("parentCode") String parentCode) {
//        PlsupLocationCriteria example  = new PlsupLocationCriteria();
//        PlsupLocationCriteria.Criteria criteria =  example.createCriteria();
//        criteria.andParentCodeEqualTo(parentCode);

        QueryWrapper<PlsupLocation> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().and(obj->
                obj.eq(PlsupLocation::getParentCode,"parentCode")
        );
        List<PlsupLocation> plsupLocations  = plsupLocationMapper.selectList(queryWrapper); //.selectByExample(example);
        //System.out.println(location);
        //System.out.println(getHttpServletRequest().getRequestURI());
        return new ResponseResult().success(plsupLocations);
    }

    @ApiOperation(value="根据PlsupLocation的JSON字符串获取plsupLocation列表", notes="根据PlsupLocation的JSON字符串获取plsupLocation列表")
    //@ApiImplicitParam(dataType = "String", paramType = "query")
    @RequestMapping(value="getPlsupLocationByCode",method = RequestMethod.POST)
    ResponseResult getPlsupLocationByCode(@RequestBody  PlsupLocation plsupLocation) {
//        PlsupLocationCriteria example  = new PlsupLocationCriteria();
//        PlsupLocationCriteria.Criteria criteria =  example.createCriteria();
//        criteria.andLocationCodeEqualTo(plsupLocation.getLocationCode());
        //List<PlsupLocation> plsupLocations  = plsupLocationMapper.selectByExample(example);
        QueryWrapper<PlsupLocation> queryWrapper = new QueryWrapper<>();
        List<PlsupLocation> plsupLocations  = plsupLocationMapper.selectList(queryWrapper);
        //System.out.println(location);
        //System.out.println(getHttpServletRequest().getRequestURI());
        return new ResponseResult().success(plsupLocations);
    }


//    public ResponseEntity<byte[]> testDownFile() throws IOException{
//
//    }

    @Autowired
    PlsupLocationMapper plsupLocationMapper;

//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Example.class, args);
//    }

}
