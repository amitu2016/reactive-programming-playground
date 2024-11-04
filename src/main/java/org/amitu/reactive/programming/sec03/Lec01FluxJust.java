package org.amitu.reactive.programming.sec03;

import org.amitu.reactive.programming.common.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxJust {

    public static void main(String[] args) {
        Flux.just(1, 2, 3, 4, "sam")
                .subscribe(Util.subscriber());
    }
}
