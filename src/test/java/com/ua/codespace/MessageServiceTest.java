package com.ua.codespace;


import com.ua.codespace.config.RootConfig;
import com.ua.codespace.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@ActiveProfiles("test")
public class MessageServiceTest {

    @Autowired
    Environment environment;

    @Autowired
    @Qualifier("testMessageService")
    MessageService messageService;

    @Value("#{messageServiceProvider.getAddress()}")
    String messageServiceAddress;

    @Value("${message.service.address}")
    private String defaultAddress;

    @Test
    public void messageServiceShouldNotBeNull() {
        assertNotNull(messageService);
    }

    @Test
    public void printMessage() {
        assertEquals(messageService.getMessage(), "Hello from test Profile");
    }

    @Test
    public void activeProfileShouldBeOnlyTest() {
        assertEquals(environment.getActiveProfiles().length, 1);
        assertEquals(environment.getActiveProfiles()[0], "test");
    }

    @Test
    public void messageServiceShouldUseDefaultAddress() {
        assertEquals(messageServiceAddress, defaultAddress);
    }
}
