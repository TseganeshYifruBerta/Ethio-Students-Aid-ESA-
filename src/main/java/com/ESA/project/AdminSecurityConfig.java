// package com.ESA.project.Admin;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.annotation.Order;
// // import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// // import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @Order(2)
// public class AdminSecurityConfig {
//     // @Override
// 	// public void configure(AuthenticationManagerBuilder auth) throws Exception {
// 	// 	auth.inMemoryAuthentication()
// 	// 		.withUser("admin").password("{noop}password").roles("ADMIN");
// 	// }
//     // // @Bean
//     @Bean
//     PasswordEncoder bcryptPasswordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public UserDetailsService userDetailsServiceadmin(AdminUserRepository adminuserRepo) {
//         return username -> {
//             AdminUsers user = adminuserRepo.findByUsername(username);
//             if (user != null) 
//             {
//                 return user;
//             }
//             throw new UsernameNotFoundException("User '" + username + "' not found");
//         };
//     }

//     @Bean
//     public SecurityFilterChain filterChainadmin(HttpSecurity http) throws Exception {
//         return http
//                 .authorizeRequests()
//                 .antMatchers("/Frontpage","/donation","/AskQ","/opportunities","/provideAnswer","/searched","/searchquestions","/questionForm","/ViewAnswer").hasRole("USERS")
//                 .antMatchers("/home").permitAll()
//                 .and()
//                 .formLogin()
//                 .loginPage("/adminlogin")
//                 .defaultSuccessUrl("/Frontpage")
//                 .and()
//                 .logout()
//                 .and()
//                 .build();
//     }
// }
