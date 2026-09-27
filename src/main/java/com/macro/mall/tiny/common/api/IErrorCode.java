package com.macro.mall.tiny.common.api;

/**
 * 封装API的错误码
 * Created by macro on 2019/4/19.
 */
//定义错误码的统一规范，规定每个业务码必须有状态码和提示信息。
public interface IErrorCode {
    long getCode();

    String getMessage();
}
