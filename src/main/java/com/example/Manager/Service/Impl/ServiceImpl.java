package com.example.Manager.Service.Impl;

import com.example.Manager.Service.ConfigService;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;

@Service
public class ServiceImpl implements ConfigService {

    @Override
    public void performService() {
        System.out.println("Performing service...");
    }
}
