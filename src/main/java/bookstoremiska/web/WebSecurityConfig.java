package bookstoremiska.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig  {
 	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests( authorize -> authorize        // / and /home paths are configured to not
				.requestMatchers("/booklist", "/css/**").permitAll()    // require any authentication.
				.requestMatchers("/delete/**").hasRole("ADMIN")
				.anyRequest().authenticated()                 // All other paths must be authenticated.
			)                                             // If you don't give loginPage
		.formLogin( formlogin -> formlogin                    // your application will use the
			.loginPage("/login")                          // spring boot default login page.
			.defaultSuccessUrl("/booklist", true)      // <-- Tells where to go after
			.permitAll()                                  // successful login.
		)
		.logout( (logout) -> logout.logoutSuccessUrl("/booklist")
			.permitAll()
		);
		return http.build();
	}


	
}