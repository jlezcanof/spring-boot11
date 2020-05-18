package edu.lez.boot8java11;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * 
 * TEST CORS as per >
 * https://stackoverflow.com/questions/46410682/angular-2-cors-spring-boot-rest-controller-with-spring-security?rq=1
 *
 *
 * This config prevents the generation of response header: Set-Cookie:
 * JSESSIONID=C147FEF74A88C36290A457BF95B28669; Path=/; HttpOnly<br>
 * and makes Angular CORS work fine... but...
 *
 *
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    final String[] pathAnonymous = { "/ui/**", "/monitor/**", "/tech/**", "/favicon*", "/version",
        "/swagger-ui.html", "/webjars/**", "/swagger-resources/**", "/", "/v2/api-docs/**", "/csrf" };
    /*- DOC:
     * Default user and pass is configured in application.properties (spring.security.user.*).
     */
    http.authorizeRequests().antMatchers(pathAnonymous).permitAll().anyRequest().anonymous().and()
        //.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and()
        .httpBasic().realmName("spring-boot8java11");
    /*- http.csrf().disable()
     * JSESSIONID !!!
     */
    http.csrf().disable();
    http.cors();
    // for show h2-console
    http.headers().frameOptions().disable();
  }

  /**
   * Allow special characters in url (';','\','/')
   */
  @Override
  public void configure(WebSecurity web) throws Exception {
    StrictHttpFirewall firewall = new StrictHttpFirewall();
    // symbol '/'
    firewall.setAllowUrlEncodedSlash(true);
    // symbol '\'
    firewall.setAllowBackSlash(true);
    // symbol ';'
    firewall.setAllowSemicolon(true);
    // symbol '%'
    firewall.setAllowUrlEncodedPercent(true);
    // @formatter:off
    web.httpFirewall(firewall);
  }

  /**
   * corsConfigurationSource.
   * 
   * @return -
   */
  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    final CorsConfiguration configuration = new CorsConfiguration();
    // DOC. api.uoc.edu already enforces CORS
    configuration.setAllowedOrigins(Arrays.asList("*"));
    configuration.setAllowedMethods(Arrays.asList("*"));
    configuration.setAllowCredentials(true);
    configuration.setAllowedHeaders(Arrays.asList("*"));

    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    // DOC api.uoc.edu already has CORS
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

}
