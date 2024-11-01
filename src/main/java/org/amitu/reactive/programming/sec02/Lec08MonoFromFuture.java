package org.amitu.reactive.programming.sec02;

import org.amitu.reactive.programming.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec08MonoFromFuture {
    private static final Logger LOGGER = LoggerFactory.getLogger(Lec08MonoFromFuture.class);

    public static void main(String[] args) {
        Mono.fromFuture(Lec08MonoFromFuture::getName)
                .subscribe(Util.subscriber());

        Util.sleep(1);
    }

    private static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(() -> {
            LOGGER.info("Generating name");
            return Util.faker().name().fullName();
        });
    }
}
