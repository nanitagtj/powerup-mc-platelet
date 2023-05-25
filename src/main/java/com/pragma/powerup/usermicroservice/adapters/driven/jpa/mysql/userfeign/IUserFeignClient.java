package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.userfeign;

import com.pragma.powerup.usermicroservice.configuration.feignConfig.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users", configuration = FeignClientConfig.class, url = "http://localhost:8080/api/user")
public interface IUserFeignClient {
    @GetMapping("/user/owner/{id}")
    boolean validUserOwner(@PathVariable("id") Long id);
}