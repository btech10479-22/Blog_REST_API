package com.theanimesh.blog.rest.api.service;

import com.theanimesh.blog.rest.api.payload.LoginDto;
import com.theanimesh.blog.rest.api.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
