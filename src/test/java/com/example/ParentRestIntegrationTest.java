package com.example;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.net.URI;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.EntityLinks;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

@SpringBootTest(classes = SpringDataRestEntityInheritanceApplication.class)
@RunWith(SpringRunner.class)
public class ParentRestIntegrationTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private EntityLinks entityLinks;

    private ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
    private MockMvc mockMvc;
    private URI parentsUri;

    @Before
    public void init() {
        mockMvc = webAppContextSetup(context) //
                .build();
        parentsUri =entityLinks.linkFor(Parent.class).toUri();
    }

    @Test
    public void should_create_percentage_value() throws Exception {
        Map<Object, Object> jsonMap = ImmutableMap.builder()
                .put("valueHolder", ImmutableMap.of(
                        "type", "DECIMAL",
                        "value", 0.95))
                .build();

        mockMvc.perform(
                post(parentsUri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jsonMap)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("valueHolder.type", equalTo("DECIMAL")))
                .andExpect(jsonPath("valueHolder.percentageValue", equalTo(0.95d)))
        ;
    }

    @Test
    public void should_get_parents() throws Exception {

        mockMvc.perform(
                get(parentsUri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }
}
