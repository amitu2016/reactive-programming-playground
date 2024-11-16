package org.amitu.reactive.programming.sec05;

import org.amitu.reactive.programming.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec04Delay {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());

        Util.sleep(12);
    }
}
