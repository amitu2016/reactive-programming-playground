package org.amitu.reactive.programming.sec03;

import org.amitu.reactive.programming.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec11FluxMono {
    public static void main(String[] args) {

        var flux = Flux.range(1, 5);
        Mono.from(flux)
                .subscribe(Util.subscriber());

    }

    private static void MonoToFlux(){
        var mono = getUserName(3);
        save(Flux.from(mono));
    }

    private static Mono<String> getUserName(int userId){
        return switch (userId){
            case 1 -> Mono.just("Sam");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("Invalid Input"));
        };
    }

    private static void save(Flux<String> flux){
        flux.subscribe(Util.subscriber());
    }
}
