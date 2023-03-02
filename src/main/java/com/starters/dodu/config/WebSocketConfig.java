package com.starters.dodu.config;

import com.starters.dodu.handler.ChatHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket//websocket을 활성화
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    ChatHandler chatHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        System.out.println("this is web socket config 1 =============");
        registry.addHandler(chatHandler,"/ws/chat")
                .setAllowedOrigins("*");
               // .setAllowedOrigins("http://localhost:8080/");
        System.out.println("this is web socket config 2 =============");

    }
   /* @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/stomp/").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        config.setApplicationDestinationPrefixes("/test");
        config.enableSimpleBroker("/topic", "/queue");
    }*/
}
