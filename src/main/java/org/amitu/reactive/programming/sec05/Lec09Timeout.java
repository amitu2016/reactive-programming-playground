package org.amitu.reactive.programming.sec05;

import org.amitu.reactive.programming.common.Util;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Lec09Timeout {

    public static void main(String[] args) {

        var mono = getProductName()
                .timeout(Duration.ofSeconds(1), fallback())
                .onErrorReturn("fallback");

        mono
                .timeout(Duration.ofMillis(500))
                .subscribe(Util.subscriber());

        Util.sleep(6);
    }

    private static Mono<String> getProductName(){
        return Mono.fromSupplier(() -> "service ->" + Util.faker().commerce().productName())
                .delayElement(Duration.ofMillis(1900));
    }

    private static Mono<String> fallback(){
        return Mono.fromSupplier(() -> "fallback ->" + Util.faker().commerce().productName())
                .delayElement(Duration.ofMillis(300));
    }

}
