package org.amitu.reactive.programming.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

   private static Logger LOGGER = LoggerFactory.getLogger(Lec03MonoSubscribe.class);

    public static void main(String[] args) {

        var mono = Mono.just(1)
                        .map(i -> i / 0);


        mono.subscribe(i -> LOGGER.info("Received : {}", i),
                err -> LOGGER.error("Error : {}",err.toString()),
                () -> LOGGER.info("Completed!")
        );
    }

}
