package bookmap.service;

public class MainServiceImpl implements MainService {
    private final Reader reader = new ReaderImpl();
    private final DataParser parser = new DataParserImpl();

    @Override
    public void execute(String input) {
        reader.read(input).forEach(parser::parse);
    }
}
