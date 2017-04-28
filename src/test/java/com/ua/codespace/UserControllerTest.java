package com.ua.codespace;

import com.ua.codespace.config.RootConfig;
import com.ua.codespace.entity.User;
import com.ua.codespace.web.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = RootConfig.class)
public class UserControllerTest {

    @Test
    public void shouldContainUserAttribute() throws Exception {
        UserController userController = new UserController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        mockMvc.perform(get("/users/John"))
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attribute("user", new User("John")));

    }

    @Test
    public void formProcessingRedirectUrlShouldContainUsername() throws Exception {
        UserController userController = new UserController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        mockMvc.perform(post("/users/add").param("username", "Peter"))
                .andExpect(redirectedUrl("/users/Peter"));

    }
}
