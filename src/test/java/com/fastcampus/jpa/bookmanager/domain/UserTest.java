package com.fastcampus.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class UserTest {

    @Test
    void test(){
        Users AA = Users.builder().name("").email("").build();

        Users user1 = new Users(null,"martin","martin@kicc.co.kr",LocalDateTime.now(),LocalDateTime.now());

    }

}