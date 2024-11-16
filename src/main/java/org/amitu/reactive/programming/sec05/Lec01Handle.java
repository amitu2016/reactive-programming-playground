package org.amitu.reactive.programming.sec05;

import org.amitu.reactive.programming.common.Util;
import reactor.core.publisher.Flux;

public class Lec01Handle {

    public static void main(String[] args) {

        Flux.range(1, 10)
            //    .filter(i -> i != 7)
                .handle((item, sink) -> {
                    switch (item){
                        case 1 -> sink.next(-2);
                        case 4 -> {}
                        case 7 -> sink.error(new RuntimeException("Oops!"));
                        default -> sink.next(item);
                    }
                })
                .subscribe(Util.subscriber());

    }
}
