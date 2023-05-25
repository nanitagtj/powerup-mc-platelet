package com.pragma.powerup.usermicroservice.domain.feigndatasource;

public interface IUserClientPort {
    boolean getUser(Long id);
}
