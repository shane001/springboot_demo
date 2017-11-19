package me.shaneli.springboot_demo.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import me.shaneli.springboot_demo.model.Demo;
import me.shaneli.springboot_demo.service.DemoService;
import me.shaneli.springboot_demo.web.controller.DemoController;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Shane
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DemoController.class)
public class TestDemoController {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DemoService demoService;

    @Test
    public void testQueryDemo() throws Exception {
        RequestBuilder requestBuilder = get("/demo/1");
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Before
    public void setUp() {
        Demo demo = new Demo();
        demo.setName("test_name");
        demo.setValue("test_value");
        given(this.demoService.queryDemoById(anyInt())).willReturn(demo);
    }

}
