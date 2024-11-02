package org.amitu.reactive.programming.sec02;

import org.amitu.reactive.programming.common.Util;
import org.amitu.reactive.programming.sec02.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec11NonBlockingIO {
    private static final Logger LOGGER = LoggerFactory.getLogger(Lec11NonBlockingIO.class);

    public static void main(String[] args) {
        var client = new ExternalServiceClient();

        LOGGER.info("Started");

        for (int i = 1; i <= 100; i++) {
            client.getProductName(i)
                    .subscribe(Util.subscriber());
        }

        Util.sleep(2);
    }
}
