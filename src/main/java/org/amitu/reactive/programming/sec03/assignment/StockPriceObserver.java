package org.amitu.reactive.programming.sec03.assignment;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StockPriceObserver implements Subscriber<Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockPriceObserver.class);
    private int quantity = 0;
    private int balance = 1000;
    private Subscription subscription;


    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
        this.subscription = subscription;
    }

    @Override
    public void onNext(Integer price) {
        if (price < 90 && balance >= price){
            quantity++;
            balance = balance - price;
            LOGGER.info("Bought a stock at {}, total quantity : {}, remaining balance : {}", price, quantity, balance);
        } else if (price > 110 && quantity > 0) {
            LOGGER.info("Selling {} quantity at {}", quantity, price);
            balance = balance + (quantity * price);
            quantity = 0;
            subscription.cancel();
            LOGGER.info("Profit made : {}", (balance - 1000));
        }
    }

    @Override
    public void onError(Throwable t) {
        LOGGER.error("Error : {}",t.toString());
    }

    @Override
    public void onComplete() {
        LOGGER.info("Completed");
    }
}
