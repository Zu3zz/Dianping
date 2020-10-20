package com.zth.dianping.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.zth.dianping.model.PeopleModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Date: 2020/6/18 3:25 下午
 *
 * @author 3zZ.
 */
@Controller("/test")
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/index")
    public String index() {
        PeopleModel peopleModel = new PeopleModel();
        peopleModel.setAge(15);
        peopleModel.setName("3zz");
        return peopleModel.toString();
    }

    @RequestMapping("/json")
    public String json() {
        PeopleModel peopleModel = new PeopleModel();
        peopleModel.setAge(15);
        peopleModel.setName("3zz");
        return JSONUtils.toJSONString(peopleModel);
    }
}
