package xyz.gggedr.board.gamesbackend.configurations

import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
@EnableAsync
@EnableWebMvc
class AsyncConfig : WebMvcConfigurer {
}