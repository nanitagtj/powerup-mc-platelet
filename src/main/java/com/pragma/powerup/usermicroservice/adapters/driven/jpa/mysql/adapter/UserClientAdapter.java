package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.userfeign.IUserFeignClient;
import com.pragma.powerup.usermicroservice.domain.feigndatasource.IUserClientPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserClientAdapter implements IUserClientPort {
    private final IUserFeignClient IUserFeignClient;
    @Override
    public boolean getUser(Long id) {
        return IUserFeignClient.validUserOwner(id);
    }
}