package com.darcytech.mvc;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.darcytech.annotation.StringTid;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by guxiaoli on 22/05/2017.
 */
public class MyHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {


    static ObjectMapper o = new ObjectMapper();

    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        return methodParameter.getMethodAnnotation(StringTid.class) != null;
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {

        //标志着此次请求是否是由handler自己控制的，true表示本方法会响应请求。
        mavContainer.setRequestHandled(true);

        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        response.setContentType("text/plain;charset=utf-8");
        Class clz = returnValue.getClass();
        String methodName = "getTid";
        Method method = clz.getMethod(methodName);
        Object value = method.invoke(returnValue);

        Map result = o.convertValue(returnValue, Map.class);
        if(value!=null){
            result.put("tid", value.toString());
        }
        response.getWriter().write(o.writeValueAsString(result));
    }





}
