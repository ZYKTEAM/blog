package com.myblog.common.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ElasticSearch配置类
 */
@Configuration
public class ElasticSearchConfig {

    /**
     * 负责生成一个es客户端
     *
     * @return
     */
    @Bean
    public TransportClient client() throws UnknownHostException {
        //获取地址  9300是es的TCP端口,可以加载多个地址
        InetSocketTransportAddress node = new InetSocketTransportAddress(
                InetAddress.getByName("localhost"),
                9300
        );
        //配置集群名称 集群名称在ES文件下config  elasticsearch.yml里
        Settings settings = Settings.builder().put("cluster.name", "zyk").build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);
        return client;
    }
}
