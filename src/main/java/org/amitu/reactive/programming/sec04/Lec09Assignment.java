package org.amitu.reactive.programming.sec04;

import org.amitu.reactive.programming.common.Util;
import org.amitu.reactive.programming.sec04.assignment.FileReaderServiceImpl;

import java.nio.file.Path;

public class Lec09Assignment {

    public static void main(String[] args) {
        var path = Path.of("src/main/resources/sec04/file.txt");
        var fileReaderService = new FileReaderServiceImpl();
        fileReaderService.read(path)
                .subscribe(Util.subscriber());
    }
}