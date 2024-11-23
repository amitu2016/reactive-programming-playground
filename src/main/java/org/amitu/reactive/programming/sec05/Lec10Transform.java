package org.amitu.reactive.programming.sec05;

import org.amitu.reactive.programming.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.function.UnaryOperator;

public class Lec10Transform {
    private static Logger LOGGER = LoggerFactory.getLogger(Lec10Transform.class);

    record Customer(int id, String name) {}
    record PurchaseOrder(String productName, int price, int quantity) {}

    public static void main(String[] args) {

        getCustomers()
                .transform(addDebugger())
                .subscribe();

        getPurchaseOrders()
                .transform(addDebugger())
                .subscribe();

    }

    private static Flux<Customer> getCustomers() {
        return Flux.range(1, 3)
                .map(i -> new Customer(i, Util.faker().name().firstName()));
    }

    private static Flux<PurchaseOrder> getPurchaseOrders() {
        return Flux.range(1, 3)
                .map(i -> new PurchaseOrder(Util.faker().commerce().productName(), i, i*10));
    }

    private static <T> UnaryOperator<Flux<T>> addDebugger() {
        return flux -> flux.doOnNext(c -> LOGGER.info("received: {}", c))
                .doOnComplete(() -> LOGGER.info("completed"))
                .doOnError(e -> LOGGER.error("error", e));
    }


}
