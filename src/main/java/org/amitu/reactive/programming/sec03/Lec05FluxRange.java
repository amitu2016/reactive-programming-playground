package org.amitu.reactive.programming.sec03;

import org.amitu.reactive.programming.common.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {

    public static void main(String[] args) {
        Flux.range(1,10)
                .subscribe(Util.subscriber("sub1"));

        Flux.range(1, 10)
                .map(i -> Util.faker().name().fullName())
                .subscribe(Util.subscriber("sub2"));

    }

}
