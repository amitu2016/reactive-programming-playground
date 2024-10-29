package org.amitu.reactive.programming.sec01.Publisher;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionImpl.class);

    private final Subscriber<? super String> subscriber;
    private boolean isCancelled;
    private final Faker faker;
    private static final int MAX_ITEMS = 10;
    private int count = 0;

    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }

    @Override
    public void request(long requested) {
        if (isCancelled){
            return;
        }
        LOGGER.info("Subscriber has requested {} items", requested);
        for (int i = 0; i < requested && count < MAX_ITEMS; i++) {
            count++;
            this.subscriber.onNext(this.faker.internet().emailAddress());
        }

        if(requested > MAX_ITEMS){
            this.subscriber.onError(new RuntimeException("Validation failed"));
            this.subscriber.onComplete();
            this.isCancelled = true;
            return;
        }

        if (count == MAX_ITEMS){
            LOGGER.info("No more items remaining to produce");
            this.subscriber.onComplete();
            this.isCancelled = true;
        }
    }

    @Override
    public void cancel() {
        LOGGER.info("Subscription Cancelled!");
        this.isCancelled = true;
    }
}
