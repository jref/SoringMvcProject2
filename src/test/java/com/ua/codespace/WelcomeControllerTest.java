package com.ua.codespace;


import com.ua.codespace.config.RootConfig;
import com.ua.codespace.service.impl.MessageServiceProvider;
import com.ua.codespace.web.controller.WelcomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = RootConfig.class)
public class WelcomeControllerTest {

    @Autowired
    MessageServiceProvider messageService;

    @Value("${message.service.defaultMessage}")
    String defaultMessage;

    @Test
    public void testWelcomePage() throws Exception {
        WelcomeController controller = new WelcomeController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/")).andExpect(view().name("welcome"));
    }
}
