package org.amitu.reactive.programming.sec03;

import org.amitu.reactive.programming.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec03FluxFromIterableOrArray {

    public static void main(String[] args) {
        var list = List.of(1,2,3,4,5);

        Flux.fromIterable(list)
                .subscribe(Util.subscriber("sub1"));

        Integer[] arr = {1,2,3,4,5,6,7,8};

        Flux.fromArray(arr)
                .subscribe(Util.subscriber("sub2"));
    }
}
