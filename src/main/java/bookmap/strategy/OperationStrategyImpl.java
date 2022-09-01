package bookmap.strategy;

import bookmap.handlers.OperationHandler;
import bookmap.handlers.OrderHandler;
import bookmap.handlers.QueryHandler;
import bookmap.handlers.UpdateHandler;
import java.util.HashMap;

public class OperationStrategyImpl implements OperationStrategy {
    private HashMap<Character, OperationHandler> strategy;

    public OperationStrategyImpl() {
        strategy = new HashMap<>();
        strategy.put('u', new UpdateHandler());
        strategy.put('q', new QueryHandler());
        strategy.put('o', new OrderHandler());
    }

    @Override
    public void comply(Character operation, String info) {
        strategy.get(operation).perform(info);
    }
}
