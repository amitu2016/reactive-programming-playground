package org.amitu.reactive.programming.sec04;

import org.amitu.reactive.programming.common.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {
    public static void main(String[] args) {
        Flux.create( fluxSink -> {
            String capital;
            do {
               capital = Util.faker().country().capital();
               fluxSink.next(capital);
            } while (!capital.equalsIgnoreCase("new delhi"));
            fluxSink.complete();
        }).subscribe(Util.subscriber());
    }
}
