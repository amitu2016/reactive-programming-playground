package org.amitu.reactive.programming.sec05;

import org.amitu.reactive.programming.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06ErrorHandling {

    private static final Logger LOGGER = LoggerFactory.getLogger(Lec06ErrorHandling.class);

    public static void main(String[] args) {

        Flux.range(1, 10)
                .map(i -> i == 5 ? i / 0 : i)
                .onErrorContinue((ex, obj) -> LOGGER.error("=====> {}",obj,ex))
                .subscribe(Util.subscriber());
    }

    private static void onErrorReturn(){
            Flux.range(1, 10)
                    .map(i -> i == 5 ? i/0 : i)
                    .onErrorReturn(IllegalArgumentException.class, -1)
                    .onErrorReturn(ArithmeticException.class, -2)
                    .subscribe(Util.subscriber());

    }

    private static void onerrorResume(){
        Mono.error(new ArithmeticException())
                .onErrorResume(ArithmeticException.class, ex -> fallback1())
                .onErrorResume(ex -> fallback2())
                .onErrorReturn(-3)
                .subscribe(Util.subscriber());
    }

    private static Mono<Integer> fallback1(){
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(10, 100));
    }

    private static Mono<Integer> fallback2(){
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 1000));
    }
}
