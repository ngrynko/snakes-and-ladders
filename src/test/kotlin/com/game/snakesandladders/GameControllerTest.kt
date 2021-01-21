package com.game.snakesandladders

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GameControllerTest {
    @LocalServerPort
    private val port = 0

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @Test
    @Throws(Exception::class)
    fun contextLoads() {
        assertThat(
            restTemplate!!.getForObject(
                "http://localhost:$port/snakes-and-ladders",
                String::class.java
            )
        ).startsWith("[{\"Initial position\":1,\"Die score\":0,\"Position after the move\":1}")
            .endsWith("\"Position after the move\":100}]")
    }
}