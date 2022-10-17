package com.example.demo.resttemplate;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestTemplateController {

    @GetMapping("/getForObject")
    public String getForObject() {

        RestTemplate restTemplate = new RestTemplate();

        AnimeChan animechan = restTemplate.getForObject(
                "https://animechan.vercel.app/api/random",
                AnimeChan.class
        );

        System.out.println(animechan.getAnime() + " 的 " + animechan.getCharacter());

        return "Get for Object Success";
    }

    @GetMapping("/getForObjectWithParam")
    public String getForObjectWithParam() {

        Map<String, Object> queryParamMap = new HashMap<>();
        queryParamMap.put("age", 20);

        RestTemplate restTemplate = new RestTemplate();

        AnimeChan animechan = restTemplate.getForObject(
                "https://animechan.vercel.app/api/random",
                AnimeChan.class,
                queryParamMap
        );

        return "Get for Object with Param Success";
    }

    @GetMapping("/getForEntity")
    public String getForEntity() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<AnimeChan> studentEntity = restTemplate.getForEntity(
                "https://animechan.vercel.app/api/random",
                AnimeChan.class
        );

        System.out.println("HTTP status code：" + studentEntity.getStatusCode());

        AnimeChan animechan = studentEntity.getBody();

        System.out.println(animechan.getAnime() + " 的 " + animechan.getCharacter());

        return "Get for Entity Success";
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @GetMapping("/postForObject")
    public String postForObject() {
        RestTemplate restTemplate = new RestTemplate();

        AnimeChan animeChanRequestBody = new AnimeChan();
        animeChanRequestBody.setCharacter("Test");

        AnimeChan result = restTemplate.postForObject(
                "https://animechan.vercel.app/api/random",
                animeChanRequestBody,
                AnimeChan.class
        );

        return "Post for Object Success";
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @GetMapping("/postForEntity")
    public String postForEntity() {
        RestTemplate restTemplate = new RestTemplate();

        AnimeChan animeChanRequestBody = new AnimeChan();
        animeChanRequestBody.setCharacter("Test");

        ResponseEntity<AnimeChan> responseEntity = restTemplate.postForEntity(
                "https://animechan.vercel.app/api/random",
                animeChanRequestBody,
                AnimeChan.class
        );

        return "Post for Entity Success";
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @GetMapping("/exchange")
    public String exchange() {
        RestTemplate restTemplate = new RestTemplate();

        // 使用 exchange 發起 GET 請求
        // 定義請求過程中要帶上哪些 header，再用一個 HttpEntity 封裝起來。
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("header1", "123");

        HttpEntity requestEntity = new HttpEntity(requestHeaders);

        Map<String, Object> queryParamMap = new HashMap<>();
        queryParamMap.put("age", 20);

        ResponseEntity<AnimeChan> getAnimeChanEntity = restTemplate.exchange(
                "https://animechan.vercel.app/api/random",
                HttpMethod.GET,
                requestEntity,
                AnimeChan.class,
                queryParamMap
        );

//        // 使用 exchange 發起 POST 請求
//        HttpHeaders requestHeaders2 = new HttpHeaders();
//        requestHeaders2.set("header2", "456");
//    // 使用比較底層的方法時，必須加上 contentType 的 header，確保 POST 請求可以正常運作。
//        requestHeaders2.setContentType(MediaType.APPLICATION_JSON);
//
//        AnimeChan animeChanRequestBody = new AnimeChan();
//        animeChanRequestBody.setCharacter("Test");
//
//        HttpEntity requestEntity2 = new HttpEntity(animeChanRequestBody, requestHeaders2);
//
//        ResponseEntity<AnimeChan> postAnimeChanEntity = restTemplate.exchange(
//                "https://mocki.io/v1/3f4cf220-9fb0-432f-ad7b-ad497f904aa4",
//                HttpMethod.POST,
//                requestEntity2,
//                AnimeChan.class
//        );

        return "Exchange Success";
    }
}
