package org.amitu.reactive.programming.sec04;

import org.amitu.reactive.programming.common.Util;
import org.amitu.reactive.programming.sec04.helper.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Lec03FluxSinkThreadSafety {

    private static final Logger LOGGER = LoggerFactory.getLogger(Lec03FluxSinkThreadSafety.class);

    public static void main(String[] args) {
        demo2();
    }
    
    public static void demo1(){
        List<Integer> list = new ArrayList<>();
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread.ofPlatform().start(runnable);
        }

        Util.sleep(3);
        LOGGER.info("List size demo1 : {}",list.size());
    }

    public static void demo2(){
        var list = new ArrayList<String>();
        var generator = new NameGenerator();
        var flux = Flux.create(generator);
        flux.subscribe(list::add);

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                generator.generate();
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread.ofPlatform().start(runnable);
        }

        Util.sleep(3);
        LOGGER.info("List size demo2 : {}",list.size());
    }
}
