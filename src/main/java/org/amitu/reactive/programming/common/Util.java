package org.amitu.reactive.programming.common;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Util {

    public static final Faker faker = Faker.instance();

    public static <T> Subscriber<T> subscriber(){
        return new DefaultSubscriber<>("");
    }

    public static <T> Subscriber<T> subscriber(String name){
        return new DefaultSubscriber<>(name);
    }

    public static Faker faker(){
        return faker;
    }

    public static void sleep(int secs){
        try {
            Thread.sleep(Duration.ofSeconds(secs));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
