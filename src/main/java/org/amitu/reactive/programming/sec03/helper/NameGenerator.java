package org.amitu.reactive.programming.sec03.helper;

import org.amitu.reactive.programming.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.IntStream;

public class NameGenerator {

    public static List<String> generateNameList(int count){
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> generateName())
                .toList();
    }

    public static Flux<String> generateNameFlux(int count){
        return Flux.range(1, count)
                .map(i -> generateName());

    }

    private static String generateName(){
        Util.sleep(1);
        return Util.faker().name().fullName();
    }
}
