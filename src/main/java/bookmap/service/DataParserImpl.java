package bookmap.service;

import bookmap.strategy.OperationStrategy;
import bookmap.strategy.OperationStrategyImpl;

public class DataParserImpl implements DataParser {
    private static final int OPERATION_INDEX = 0;
    private static final int OPERATION_INFO_INDEX = 2;

    private final OperationStrategy strategy = new OperationStrategyImpl();

    @Override
    public void parse(String line) {
        Character operation = line.charAt(OPERATION_INDEX);
        if (!operation.toString().matches("[uqo]") || line.isEmpty()) {
            throw new RuntimeException("Couldn't parse info from string " + line);
        }
        strategy.comply(operation, line.substring(OPERATION_INFO_INDEX));
    }
}
