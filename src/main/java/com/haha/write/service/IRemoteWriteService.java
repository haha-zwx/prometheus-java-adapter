package com.haha.write.service;

import prometheus.Remote;

/**
 * @author haha
 * @description:
 * @date 2019/4/810:25
 */
public interface IRemoteWriteService {

    /**
     * @param data    : 数据
     * @param version :Prometheus版本
     * @description: 处理Prometheus发来的请求
     * @create by: haha time: 2019/4/8 16:05
     */
    void resolveRequest(byte[] data, String version);

    /**
     * @param request:Prometheus数据
     * @description: 把请求内容json存储到kafka
     * @create by: haha  time: 2019/4/8 16:06
     */
    void load2Kafka(Remote.WriteRequest request);

    /**
     * @param request:Prometheus数据
     * @description: 把请求内容json存储到oracle
     * @create by: haha  time: 2019/4/8 16:06
     */
    void load2ORAC(Remote.WriteRequest request);

    /**
     * @param request:Prometheus数据
     * @description: 把请求内容json存储到mysql
     * @create by: haha  time: 2019/4/8 16:06
     */
    void load2MYSQL(Remote.WriteRequest request);
}
