package mingu.spring.postservice.config;

import feign.codec.ErrorDecoder;
import mingu.spring.postservice.feign.MessageErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorDecoderBean {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new MessageErrorDecoder();
    }
}
