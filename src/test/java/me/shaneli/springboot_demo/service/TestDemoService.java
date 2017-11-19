package me.shaneli.springboot_demo.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import me.shaneli.springboot_demo.dao.DemoMapper;
import me.shaneli.springboot_demo.model.Demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyObject;

/**
 * @author Shane
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemoService {

    @MockBean
    private DemoMapper demoMapper;
    @Autowired
    private DemoService demoService;

    @Test
    public void testAddDemo() {
        Demo demo = new Demo();
        demo.setName("test_name");
        demo.setValue("test_value");

        boolean res = this.demoService.addDemo(demo);

        assertThat(res).isEqualTo(true);
    }

    @Before
    public void setUp(){
        given(this.demoMapper.insertDemo(anyObject())).willReturn(1);
    }

}
