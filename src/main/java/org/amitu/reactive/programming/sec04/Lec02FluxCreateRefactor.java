package org.amitu.reactive.programming.sec04;

import org.amitu.reactive.programming.common.Util;
import org.amitu.reactive.programming.sec04.helper.NameGenerator;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactor {

    public static void main(String[] args) {
        var generator = new NameGenerator();
        var flux = Flux.create(generator);
        flux.subscribe(Util.subscriber());

        for (int i = 1; i < 10; i++) {
            generator.generate();
        }
    }
}
