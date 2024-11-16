package org.amitu.reactive.programming.sec05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec05Subscribe {

    private static final Logger LOGGER = LoggerFactory.getLogger(Lec05Subscribe.class);

    public static void main(String[] args) {

        Flux.range(1, 10)
                .doOnNext(i -> LOGGER.info("Received: {}", i))
                .doOnComplete(() -> LOGGER.info("Completed"))
                .doOnError(err -> LOGGER.error("Error : {}", err.toString()))
                .subscribe();
    }
}
