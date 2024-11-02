package org.amitu.reactive.programming.sec02.client;

import org.amitu.reactive.programming.common.AbstractHttpClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

public class ExternalServiceClient extends AbstractHttpClient {

    public Mono<String> getProductName(int productId){
       return this.httpClient.get()
                .uri("/demo01/product/" +productId)
                .responseContent()
                .asString()
                .next();
    }
}
