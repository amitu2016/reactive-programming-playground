package org.amitu.reactive.programming.sec02;

import org.amitu.reactive.programming.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec05MonoFromSupplier {

    private static final Logger LOGGER = LoggerFactory.getLogger(Lec05MonoFromSupplier.class);

    public static void main(String[] args) {
        var list = List.of(5, 2, 3);
        Mono.fromSupplier(() -> sum(list))
               .subscribe(Util.subscriber());
    }

    private static int sum(List<Integer> list){
        LOGGER.info("Finding the sum of list : {}", list);
        return list.stream().mapToInt(a -> a).sum();
    }
}
