package org.amitu.reactive.programming.sec05;

import org.amitu.reactive.programming.common.Util;
import reactor.core.publisher.Mono;

public class Lec07DefaultIfEmpty {

    public static void main(String[] args) {
        Mono.empty()
                .defaultIfEmpty("fallback")
                .subscribe(Util.subscriber());
    }
}
