package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getById() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/students/3")
                .header("headerName", "headerValue") // 為該 http request 添加一個自定義的 request header
                .queryParam("graduate", "true");
        // 驗證回傳 http status code 是否為 200
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andDo(print()) // 輸出該 API 執行結果
                .andExpect(status().is(200)) // 檢查回傳的 http status code 是否為 200
                .andExpect(jsonPath("$.id", equalTo(3))) // 取得 Json 中的某個 key 值，並檢查是否為 3。
                .andExpect(jsonPath("$.name", notNullValue())) // 取得 Json 中的某個 name 值，並檢查是否不為 null。
                .andReturn(); // 取得完整 API 執行結果

        // 取得該 API 所回傳的 response body
        String body = mvcResult.getResponse().getContentAsString();
        System.out.println("回傳的 response body 為：" + body);
    }

    @Test
    public void create() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"name\": \"Hank\",\n" +
                        " \"score\": 14.6,\n" +
                        " \"graduate\": false\n" +
                        "}");

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(201));
    }
}