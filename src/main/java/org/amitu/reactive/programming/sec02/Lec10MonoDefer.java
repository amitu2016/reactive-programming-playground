package org.amitu.reactive.programming.sec02;

import org.amitu.reactive.programming.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec10MonoDefer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Lec10MonoDefer.class);

    public static void main(String[] args) {
        Mono.defer(Lec10MonoDefer::createPublisher)
               .subscribe(Util.subscriber());
    }

    private static Mono<Integer> createPublisher(){
        var list = List.of(5, 2, 3);
        Util.sleep(1);
        LOGGER.info("Creating Publisher");
        return Mono.fromSupplier(() -> sum(list));
    }

    private static int sum(List<Integer> list){
        LOGGER.info("Finding the sum of list : {}", list);
        Util.sleep(3);
        return list.stream().mapToInt(a -> a).sum();
    }
}
