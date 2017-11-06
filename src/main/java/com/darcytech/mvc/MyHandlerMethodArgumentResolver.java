package com.darcytech.mvc;

import java.lang.reflect.Field;

import org.springframework.core.MethodParameter;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.darcytech.annotation.MyData;

/**
 * Created by guxiaoli on 19/05/2017.
 */
public class MyHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver{



    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(MyData.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        if (binderFactory==null) {
            return null;
        }
        Class<?> targetType=parameter.getParameterType();
        MyData myForm=parameter.getParameterAnnotation(MyData.class);
        String prefix=getprefix(myForm,targetType);
        Object arg=null;
        Field[] fields=targetType.getDeclaredFields();
        Object target=targetType.newInstance();
        WebDataBinder binder = binderFactory.createBinder(webRequest, null,prefix);
        for(Field field:fields){
            field.setAccessible(true);
            String fieldName=field.getName();
            Class<?> fieldType=field.getType();
            arg = binder.convertIfNecessary(webRequest.getParameter(prefix+"."+fieldName),fieldType, parameter);
            field.set(target,arg);
        }
        return target;
    }

    private String getprefix(MyData myForm,Class<?> targetType) {
        String prefix=myForm.value();
        if(prefix.equals("")){
            prefix=getDefaultClassName(targetType);
        }
        return prefix;
    }

    private String getDefaultClassName(Class<?> targetType) {
        return ClassUtils.getShortNameAsProperty(targetType);
    }
}
