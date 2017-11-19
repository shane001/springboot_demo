package me.shaneli.springboot_demo.service;

import me.shaneli.springboot_demo.model.Demo;

/**
 * @author Shane
 */
public interface DemoService {

    Demo queryDemoById(int id);

    boolean addDemo(Demo demo);

    void putToCache(String value);

    String queryFromCache();

}
