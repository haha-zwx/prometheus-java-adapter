package com.haha.write.protocol;

import com.haha.write.protocol.models.DefaultAdapter;
import lombok.extern.slf4j.Slf4j;
import prometheus.Remote;

/**
 * @author haha
 * @description:
 * @date 2019/4/810:28
 */
@Slf4j
public class ProtocolAdapter {

    /**
     * @description: exec prometheus req data dependency prometheus version
     * @param  data:prometheus req data
     * @param  version:prometheus version
     * @return byte[]
     * @create by: haha  time: 2019/4/8 10:37
     */
    public static Remote.WriteRequest exec(byte[] data, String version){
        log.debug(" ProtocolFactory exec... version: {}",version);
       switch (version){
           case "2.6.0":
               return DefaultAdapter.exec(data);
           default:
               return null;
       }
    }
}
