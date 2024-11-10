package org.amitu.reactive.programming.sec03;

import org.amitu.reactive.programming.common.Util;
import org.amitu.reactive.programming.sec03.assignment.StockPriceObserver;
import org.amitu.reactive.programming.sec03.client.ExternalServiceClient;

public class Lec12Assignment {
    public static void main(String[] args) {
        var client = new ExternalServiceClient();

        var subscriber = new StockPriceObserver();

        client.getPriceChanges()
                .subscribe(subscriber);

        Util.sleep(20);
    }
}
