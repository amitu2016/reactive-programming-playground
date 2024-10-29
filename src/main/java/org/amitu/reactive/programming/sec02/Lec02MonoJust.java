package org.amitu.reactive.programming.sec02;

import org.amitu.reactive.programming.sec01.Subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    private static Logger LOGGER = LoggerFactory.getLogger(Lec02MonoJust.class);

    public static void main(String[] args) {

        var mono = Mono.just("amit");
        var subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);

        subscriber.getSubscription().request(10);
    }
}
