package org.amitu.reactive.programming.sec03;

import org.amitu.reactive.programming.common.Util;
import reactor.core.publisher.Flux;

public class Lec06Log {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .subscribe(Util.subscriber());
    }
}
