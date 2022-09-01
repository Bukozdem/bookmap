package bookmap;

import bookmap.service.MainService;
import bookmap.service.MainServiceImpl;

public class App {
    private static final MainService service = new MainServiceImpl();
    private static final String INPUT = "input.txt";

    public static void main(String[] args) {
        service.execute(INPUT);
    }
}
