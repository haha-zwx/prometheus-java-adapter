package com.haha.write;

import com.haha.write.service.IRemoteWriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haha
 * @description: Prometheus远程写api接入
 * @date 2019/4/414:15
 */
@Slf4j
@RestController
public class RemoteWriteApi {

  @Autowired
  private IRemoteWriteService remoteWriteService;

  @Value("${prometheus.version}")
  private String version;

  /**
   * @create by: haha
   * @create time: 2019/4/4 14:17
   */
  @PostMapping("write")
  public void write(@RequestBody byte[] data) {
    log.debug(" receive msg from Prometheus ...");
    remoteWriteService.resolveRequest(data, version);
  }
}
