package org.amitu.reactive.programming.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class Lec01LazyStreams {

    private static final Logger LOGGER = LoggerFactory.getLogger(Lec01LazyStreams.class);

    public static void main(String[] args) {

        Stream.of(1)
                .peek(i -> LOGGER.info("Received : {}", i))
                .toList();
    }
}
