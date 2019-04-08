package com.haha.write.service.impl;

import com.haha.write.protocol.ProtocolAdapter;
import com.haha.write.service.IRemoteWriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import prometheus.Remote;

/**
 * @author haha
 * @description:
 * @date 2019/4/810:25
 */
@Slf4j
@Service("remoteWriteService")
public class RemoterWriteServiceImpl implements IRemoteWriteService {

    @Async("asyncPoolTaskExecutor")
    @Override
    public void resolveRequest(byte[] data, String version) {
        Remote.WriteRequest request = ProtocolAdapter.exec(data, version);
    }

    @Async("asyncPoolTaskExecutor")
    @Override
    public void load2Kafka(Remote.WriteRequest request) {

    }

    @Async("asyncPoolTaskExecutor")
    @Override
    public void load2ORAC(Remote.WriteRequest request) {

    }

    @Async("asyncPoolTaskExecutor")
    @Override
    public void load2MYSQL(Remote.WriteRequest request) {

    }
}
