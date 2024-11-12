package org.amitu.reactive.programming.sec04;

import org.amitu.reactive.programming.common.Util;
import org.amitu.reactive.programming.sec01.Publisher.SubscriptionImpl;
import org.amitu.reactive.programming.sec01.Subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateDownstreamDemand {

    private static final Logger LOGGER = LoggerFactory.getLogger(Lec04FluxCreateDownstreamDemand.class);

    public static void main(String[] args) {
        produceOnDemand();

    }

    private static void produceEarly() {
        var subscriber = new SubscriberImpl();

        Flux.<String>create(fluxSink -> {
            for (int i = 0; i < 10; i++) {
                var name = Util.faker().name().firstName();
                LOGGER.info("Generated : {}",name);
                fluxSink.next(name);
            }
            fluxSink.complete();
        }).subscribe(subscriber);

        Util.sleep(2);
        subscriber.getSubscription().request(2);
        Util.sleep(2);
        subscriber.getSubscription().request(2);
        Util.sleep(2);
        subscriber.getSubscription().request(2);

        Util.sleep(2);
        subscriber.getSubscription().cancel();
    }

    private static void produceOnDemand(){
        var subscriber = new SubscriberImpl();

        Flux.<String>create(fluxSink -> {
            fluxSink.onRequest(request -> {
                for (int i = 0; i < request && !fluxSink.isCancelled(); i++) {
                    var name = Util.faker().name().firstName();
                    LOGGER.info("Generated in produceOnDemand : {}",name);
                    fluxSink.next(name);
                }
            });

        }).subscribe(subscriber);

        Util.sleep(2);
        subscriber.getSubscription().request(2);
        Util.sleep(2);
        subscriber.getSubscription().request(2);

        Util.sleep(2);
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(2);
    }
}
