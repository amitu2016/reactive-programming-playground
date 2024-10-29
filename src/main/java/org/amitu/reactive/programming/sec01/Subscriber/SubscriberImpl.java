package org.amitu.reactive.programming.sec01.Subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriberImpl implements Subscriber<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriberImpl.class);
    private Subscription subscription;

    public Subscription getSubscription() {
        return subscription;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void onNext(String email) {
        LOGGER.info("Received : {}",email);
    }

    @Override
    public void onError(Throwable throwable) {
        LOGGER.error("Error : {}",throwable.toString());
    }

    @Override
    public void onComplete() {
        LOGGER.info("Completed !");
    }
}
