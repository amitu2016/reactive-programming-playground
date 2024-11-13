package org.amitu.reactive.programming.sec04;

import org.amitu.reactive.programming.common.Util;
import reactor.core.publisher.Flux;

public class Lec05TakeOperator {

    public static void main(String[] args) {
        //take();
        //takeWhile();
        takeUntil();
    }

    private static void take(){
        Flux.range(1, 10)
                .log("take")
                .take(3)
                .log("sub")
                .subscribe(Util.subscriber());
    }

    private static void takeWhile(){
        Flux.range(1, 10)
                .log("take")
                .takeWhile(i -> i < 5)
                .log("sub")
                .subscribe(Util.subscriber());
    }

    private static void takeUntil(){
        Flux.range(1, 10)
                .log("take")
                .takeUntil(i -> i > 5)
                .log("sub")
                .subscribe(Util.subscriber());
    }

}
