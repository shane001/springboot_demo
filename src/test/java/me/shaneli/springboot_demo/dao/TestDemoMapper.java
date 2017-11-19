package me.shaneli.springboot_demo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import me.shaneli.springboot_demo.model.Demo;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Shane
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class TestDemoMapper {

    @Autowired
    private DemoMapper demoMapper;

    @Test
    public void testInsertDemo() {
        Demo demo = new Demo();
        demo.setName("test_name");
        demo.setValue("test_value");

        int res = this.demoMapper.insertDemo(demo);
        assertThat(res).isGreaterThan(0);
    }

}
