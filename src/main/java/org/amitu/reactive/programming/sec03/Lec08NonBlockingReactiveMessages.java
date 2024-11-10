package org.amitu.reactive.programming.sec03;

import org.amitu.reactive.programming.common.Util;
import org.amitu.reactive.programming.sec03.client.ExternalServiceClient;

public class Lec08NonBlockingReactiveMessages {
    public static void main(String[] args) {
        var client = new ExternalServiceClient();

        client.getNames()
                .subscribe(Util.subscriber("sub1"));

        client.getNames()
                .subscribe(Util.subscriber("sub2"));

        Util.sleep(6);
    }
}
