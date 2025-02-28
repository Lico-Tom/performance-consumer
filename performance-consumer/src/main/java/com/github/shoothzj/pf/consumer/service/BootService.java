/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.github.shoothzj.pf.consumer.service;

import com.github.shoothzj.pf.consumer.config.PfConfig;
import com.github.shoothzj.pf.consumer.kafka.KafkaBootService;
import com.github.shoothzj.pf.consumer.mqtt.MqttBootService;
import com.github.shoothzj.pf.consumer.pulsar.PulsarBootService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author hezhangjian
 */
@Slf4j
@Service
public class BootService {

    @Autowired
    private PfConfig pfConfig;

    @Autowired
    private KafkaBootService kafkaBootService;

    @Autowired
    private MqttBootService mqttBootService;

    @Autowired
    private PulsarBootService pulsarBootService;

    @PostConstruct
    public void init() throws Exception {
        switch (pfConfig.middleware) {
            case DUMMY:
                log.info("dummy middleware");
                break;
            case KAFKA:
                kafkaBootService.boot();
                break;
            case MQTT:
                mqttBootService.boot();
                break;
            case PULSAR:
                pulsarBootService.boot();
                break;
            default:
                break;
        }
    }

}
