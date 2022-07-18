package com.dwh.bi.common.service;

/**
 * 喜马拉雅 http client
 * @author zhangyx-v
 */
public interface IXiMaLaYaService {

    /**
     * 发送手机验证码
     * @param phoneNumber 手机号
     * @return 验证码
     */
    String sendPhoneCheckNumber (String phoneNumber);

    /**
     * 手机登录
     * @param phoneNumber 手机号
     * @param code 验证码
     */
    void loginByPhoneNumber (String phoneNumber , String code);





}
