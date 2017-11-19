package me.shaneli.springboot_demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.shaneli.springboot_demo.model.Demo;
import me.shaneli.springboot_demo.service.DemoService;
import me.shaneli.springboot_demo.web.base.Response;

/**
 * @author Shane
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/demo/{id}", method = RequestMethod.GET)
    public Response queryDemo(@PathVariable("id") int id) {
        Demo demo = this.demoService.queryDemoById(id);

        return Response.success(demo);
    }

    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    public Response addDemo(@RequestBody Demo demo) {
        boolean res = this.demoService.addDemo(demo);

        return Response.success(res);
    }

    @RequestMapping(value = "/cache", method = RequestMethod.GET)
    public Response queryCache() {
        String value = this.demoService.queryFromCache();

        return Response.success(value);
    }

    @RequestMapping(value = "/cache", method = RequestMethod.POST)
    public Response saveCache(@RequestParam("value") String value) {
        this.demoService.putToCache(value);

        return Response.success(null);
    }

    @RequestMapping(value = "/exception")
    public Response exception() {
        throw new RuntimeException("exception");
    }

}
