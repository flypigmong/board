package com.example.board.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

        @RestController // REST API 컨트롤러
        public class FirstApiController {
            @GetMapping("/api/hello")
            public String hello() {
                return "hello world!";
            }


        }
