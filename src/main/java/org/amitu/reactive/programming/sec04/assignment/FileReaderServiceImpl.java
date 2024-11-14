package org.amitu.reactive.programming.sec04.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class FileReaderServiceImpl implements FileReaderService{

    private static final Logger LOGGER = LoggerFactory.getLogger(FileReaderServiceImpl.class);

    @Override
    public Flux<String> read(Path path) {
        return Flux.generate(
                () -> openFile(path),
                this::readFile,
                this::closeFile

        );
    }

    private BufferedReader openFile(Path path) throws IOException {
        LOGGER.info("Opening File");
        return Files.newBufferedReader(path);
    }

    private BufferedReader readFile(BufferedReader bufferedReader, SynchronousSink<String> sink){
        try {
            var line = bufferedReader.readLine();
            LOGGER.info("Reading Line : {}",line);
            if (Objects.isNull(line)){
                sink.complete();
            }else {
                sink.next(line);
            }
        } catch (Exception e) {
            sink.error(e);
        }
        return bufferedReader;
    }

    private void closeFile(BufferedReader bufferedReader){
        try {
            bufferedReader.close();
            LOGGER.info("File Closed");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
