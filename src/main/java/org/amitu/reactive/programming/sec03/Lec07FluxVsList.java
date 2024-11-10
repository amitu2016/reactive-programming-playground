package org.amitu.reactive.programming.sec03;

import org.amitu.reactive.programming.common.Util;
import org.amitu.reactive.programming.sec03.helper.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec07FluxVsList {

    private static final Logger LOGGER = LoggerFactory.getLogger(Lec07FluxVsList.class);

    public static void main(String[] args) {
//        var list = NameGenerator.generateNameList(10);
//        LOGGER.info(list.toString());

        NameGenerator.generateNameFlux(10)
                .subscribe(Util.subscriber());
    }
}
