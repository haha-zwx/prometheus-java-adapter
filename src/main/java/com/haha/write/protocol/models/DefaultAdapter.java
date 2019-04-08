package com.haha.write.protocol.models;

import lombok.extern.slf4j.Slf4j;
import org.xerial.snappy.Snappy;
import prometheus.Remote;

import java.io.IOException;

/**
 * -prometheus : version2.6.0
 * -Snappy.uncompress
 * -grpc Serializable
 * @author haha
 * @description:
 * @date 2019/4/810:33
 */
@Slf4j
public class DefaultAdapter {

    public static Remote.WriteRequest exec(byte[] data){
        byte[] compressed;
        Remote.WriteRequest writeRequest=null;
        try {
            compressed = Snappy.uncompress(data);
            writeRequest = Remote.WriteRequest.parseFrom(compressed);
            log.debug("info from Prometheus:{}", writeRequest);
        } catch (IOException e) {
            log.error("receive msg from Prometheus error", e);
        }
        return writeRequest;
    }
}
