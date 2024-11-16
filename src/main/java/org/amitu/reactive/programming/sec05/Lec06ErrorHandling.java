package org.amitu.reactive.programming.sec05;

import org.amitu.reactive.programming.common.Util;
import reactor.core.publisher.Flux;

public class Lec06ErrorHandling {

    public static void main(String[] args) {

    }

    private static void onErrorReturn(){
            Flux.range(1, 10)
                    .map(i -> i == 5 ? i/0 : i)
                    .onErrorReturn(IllegalArgumentException.class, -1)
                    .onErrorReturn(ArithmeticException.class, -2)
                    .subscribe(Util.subscriber());

    }
}
