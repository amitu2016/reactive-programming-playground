package org.amitu.reactive.programming.sec03;

import org.amitu.reactive.programming.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {

    public static void main(String[] args) {
        var list = List.of(1,2,3,4,5,6,7);

        var stream = list.stream();

        var flux = Flux.fromStream(list::stream);

        flux.subscribe(Util.subscriber("sub1"));

        flux.subscribe(Util.subscriber("sub2"));
    }
}
