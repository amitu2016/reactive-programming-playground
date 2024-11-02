package org.amitu.reactive.programming.common;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSubscriber<T> implements Subscriber<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSubscriber.class);
    private final String name;

    public DefaultSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T item) {
        LOGGER.info("{} Received : {}",this.name, item);
    }

    @Override
    public void onError(Throwable throwable) {
        LOGGER.error("{} Error : {}",this.name,  throwable.toString());
    }

    @Override
    public void onComplete() {
       // LOGGER.info("{} Completed !", this.name);
    }
}
