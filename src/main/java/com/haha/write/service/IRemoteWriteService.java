package com.haha.write.service;

import prometheus.Remote;

/**
 * @author haha
 * @description:
 * @date 2019/4/810:25
 */
public interface IRemoteWriteService {

    void resolveRequest(byte[] data,String version);

    void load2Kafka(Remote.WriteRequest request);

    void load2ORAC(Remote.WriteRequest request);

    void load2MYSQL(Remote.WriteRequest request);
}
