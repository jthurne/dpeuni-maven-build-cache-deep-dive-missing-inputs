package com.example.application;

import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.StdIo;
import org.junitpioneer.jupiter.StdOut;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ApplicationStartupTest {

    @Test
    @StdIo
    public void checkConsoleOutput(StdOut out) throws IOException {
        // Read the directory from the environment variable
        Path testInputDir = Paths.get(System.getenv("INTEGRATION_TEST_SAMPLES"));

        // For each file in directory, call main
        try (Stream<Path> integrationTestSamples = Files.list(testInputDir)) {
            integrationTestSamples.sorted()
                    .forEach(path -> Main.main(new String[]{path.toString()}));
        }

        // expect System output
        assertEquals("Hello Build Cache training!", out.capturedLines()[0]);
        assertEquals("Build cache is awesome!", out.capturedLines()[1]);
    }
}
