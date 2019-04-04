package com.haha.write;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.xerial.snappy.Snappy;

import java.io.IOException;

import static prometheus.Remote.WriteRequest;

/**
 * @author haha
 * @description: Prometheus远程写api接入
 * @date 2019/4/414:15
 */
@Slf4j
@RestController
public class RemoteWriteApi {

  /**
   * @create by: haha
   * @create time: 2019/4/4 14:17
   */
  @PostMapping("write")
  public void write(@RequestBody byte[] data) {
    log.debug(" receive msg from Prometheus ...");
    byte[] compressed;
    WriteRequest writeRequest;
    try {
      compressed = Snappy.uncompress(data);
      writeRequest = WriteRequest.parseFrom(compressed);
      log.debug("info from Prometheus:{}", writeRequest);
    } catch (IOException e) {
      log.error("receive msg from Prometheus error", e);
    }
  }
}
