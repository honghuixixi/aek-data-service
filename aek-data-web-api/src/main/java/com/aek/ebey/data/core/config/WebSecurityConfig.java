package com.aek.ebey.data.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.aek.common.core.serurity.JwtAuthenticationEntryPoint;
import com.aek.common.core.serurity.JwtAuthenticationTokenFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;
    @Autowired
    private JwtAuthenticationTokenFilter tokenFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // we don't need CSRF because our token is invulnerable
                .csrf()
                .disable()

                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and()

                // don't create session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/webjars/**")
                .permitAll()
                .antMatchers("/swagger-resources/**")
                .permitAll()
                .antMatchers("/v2/api-docs")
                .permitAll()
                .antMatchers("/images/*.jpg")
                .permitAll()
                .antMatchers("/images/*.png")
                .permitAll()
                .antMatchers("/**/*.js")
                .permitAll()
                .antMatchers("/**/*.css")
                .permitAll()
                .antMatchers("/**/*.woff")
                .permitAll()
                .antMatchers("/**/*.woff2")
                .permitAll()
                .antMatchers("/**/*.jsp")
                .permitAll()
                .antMatchers("/**/*.html")
                .permitAll()
                .antMatchers("/favicon.ico")
                .permitAll()
                //资产统计数据接口不需要验证Token
                .antMatchers("/data/assetsData/addAssetsData")
                .permitAll()
                .antMatchers("/data/assetsData/addAssetsDataMonth")
                .permitAll()
                //巡检统计数据接口不需要验证Token
                .antMatchers("/data/qcInspectionData/addQcInspectionData")
                .permitAll()
                .antMatchers("/data/qcInspectionData/addQcInspectionDataMonth")
                .permitAll()
                //PM统计数据接口不需要验证Token
                .antMatchers("/data/qcPmData/addQcPmData")
                .permitAll()
                .antMatchers("/data/qcPmData/addQcPmDataMonth")
                .permitAll()
                //维修统计数据接口不需要验证Token
                .antMatchers("/data/repairData/addRepairData")
                .permitAll()
                .antMatchers("/data/repairData/addRepairDataMonth")
                .permitAll()
                .antMatchers("/data/repairServenCompleteRate/addRepairServenCompleteRate")
                .permitAll()
                .anyRequest()
                .authenticated();

        // Custom JWT based security filter
        httpSecurity.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);

        // disable page caching
        httpSecurity.headers().cacheControl();
    }
}