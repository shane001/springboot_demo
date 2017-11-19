package me.shaneli.springboot_demo.dao;

import org.apache.ibatis.annotations.Mapper;

import me.shaneli.springboot_demo.model.Demo;

/**
 * @author Shane
 */
@Mapper
public interface DemoMapper {

    Demo selectById(int id);

    int insertDemo(Demo demo);

}
