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

package com.github.shoothzj.pf.consumer.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author hezhangjian
 */
@Configuration
@Service
public class KafkaConfig {

    @Value("${KAFKA_ADDR:localhost:9092}")
    public String addr;

    @Value("${KAFKA_TOPIC:0}")
    public String topic;

    @Value("${KAFKA_TOPIC_SUFFIX_NUM:0}")
    public int topicSuffixNum;

    @Value("${KAFKA_GROUP_ID:0}")
    public String groupId;

    @Value("${KAFKA_AUTO_OFFSET_RESET_CONFIG:latest}")
    public String autoOffsetResetConfig;

    @Value("${KAFKA_MAX_POLL_RECORDS:500}")
    public int maxPollRecords;

    @Value("${KAFKA_POLL_MS:500}")
    public int pollMs;

}
