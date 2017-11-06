package com.darcytech.mvc;

import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.darcytech.controller.TestController;
import com.darcytech.model.Trade;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by guxiaoli on 19/05/2017.
 */
@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice{
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        //对body 做一些加密等工作
        return body;
    }
}
