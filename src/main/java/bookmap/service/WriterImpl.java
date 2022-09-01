package bookmap.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {
    private static final String OUTPUT = "output.txt";

    @Override
    public void write(String data) {
        File file = new File(OUTPUT);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(data);
            writer.write(System.lineSeparator());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write to file " + file.getName(), e);
        }

    }
}
