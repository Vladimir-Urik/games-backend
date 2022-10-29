package xyz.gggedr.board.gamesbackend.configurations.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer.AuthorizationManagerRequestMatcherRegistry
import org.springframework.security.web.SecurityFilterChain
import xyz.gggedr.board.gamesbackend.enums.Role


@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer {
                web: WebSecurity -> web.ignoring().antMatchers("/**")
        }
    }

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain? {
        http
            .authorizeRequests()
            .antMatchers("/panel/**").authenticated()
            .antMatchers("/admin/**").hasAnyRole(Role.FOUNDER.name, Role.ADMIN.name, Role.FOUNDER.name)
            .and()
            .formLogin().disable()
            .httpBasic().disable()
            .csrf().disable()
        return http.build()
    }

}