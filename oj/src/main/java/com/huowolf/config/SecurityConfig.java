package com.huowolf.config;

import com.huowolf.security.LoginAuthenticationFilter;
import com.huowolf.security.MyAuthenticationSuccessHandler;
import com.huowolf.security.LoginAuthenticationFailureHandler;
import com.huowolf.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private MyUserDetailsService myUserService;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        String[] allowUrls = {
                                "/", "/index",
                                "/login",
                                "/randCode",
                                "/register"};

        http
                .authorizeRequests()
                .antMatchers(allowUrls).permitAll()
                .anyRequest().authenticated()
                .and()
                    .addFilterBefore(loginAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .exceptionHandling()
                    .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")) //使用新的登录切入点
                .and()
            //.formLogin()
                //.loginPage("/login")
                 //.loginProcessingUrl("/login/form")
               // .successHandler(myAuthenticationSuccessHandler)
               // .permitAll()
               // .and()
                    //.rememberMe()
                    //.userDetailsService(myUserService)
                    //.tokenRepository(persistentTokenRepository())
                    //.tokenValiditySeconds(3600)
                //.and()
                    .logout()
                    .invalidateHttpSession(true)
                    .permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("admin").roles("ADMIN");
        auth.userDetailsService(myUserService)
            .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //web.debug(true);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean //需要显示声明该bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public LoginAuthenticationFilter loginAuthenticationFilter() throws Exception {
        LoginAuthenticationFilter loginAuthenticationFilter = new LoginAuthenticationFilter();
        loginAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
        loginAuthenticationFilter.setAuthenticationSuccessHandler(myAuthenticationSuccessHandler());
        loginAuthenticationFilter.setAuthenticationFailureHandler(loginAuthenticationFailureHandle());
        loginAuthenticationFilter.setRememberMeServices(persistentTokenBasedRememberMeServices());
        return loginAuthenticationFilter;
    }


    @Bean
    public MyAuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        MyAuthenticationSuccessHandler myAuthenticationSuccessHandler = new MyAuthenticationSuccessHandler();
        return myAuthenticationSuccessHandler;
    }

    @Bean
    public LoginAuthenticationFailureHandler loginAuthenticationFailureHandle(){
        LoginAuthenticationFailureHandler loginAuthenticationFailureHandler = new LoginAuthenticationFailureHandler();
        return loginAuthenticationFailureHandler;
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }


    /**
     * 注意首页默认是不受保护的，故记住我的自动登录功能是访问任一受保护页面时生效的
     * @return
     */
    @Bean
    public PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices(){
        PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices
                = new PersistentTokenBasedRememberMeServices("oj",myUserService,persistentTokenRepository());
        persistentTokenBasedRememberMeServices.setTokenValiditySeconds(3600*24);
        return persistentTokenBasedRememberMeServices;
    }

}
