package org.amitu.reactive.programming.sec02;

import org.amitu.reactive.programming.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lecture07MonoFromRunnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Lecture07MonoFromRunnable.class);

    public static void main(String[] args) {
        getProductName(10)
                .subscribe(Util.subscriber());
    }

    private static Mono<String> getProductName(int productId){
        if (productId == 1){
            return Mono.fromSupplier(() -> Util.faker().commerce().productName());
        }

        return Mono.fromRunnable(() -> notifyBusiness(productId));
    }

    private static void notifyBusiness(int productId){
      LOGGER.info("Notifying Business on Unavailable Product : {}", productId);
    }
}
