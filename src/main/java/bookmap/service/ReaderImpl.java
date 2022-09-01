package bookmap.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderImpl implements Reader {
    private final DataParser parser = new DataParserImpl();

    @Override
    public List<String> read(String input) {
        List<String> inputData;
        File file = new File(input);
        try {
            inputData = Files.readAllLines(Path.of(file.getPath()));
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file " + file.getName(), e);
        }
        return inputData;
    }
}
