package bookmap.handlers;

import bookmap.dao.ShareDao;
import bookmap.dao.ShareDaoImpl;
import java.util.Objects;

public class OrderHandler implements OperationHandler {
    private static final int OPERATION_INDEX = 0;
    private static final int SIZE_INDEX = 1;
    private final ShareDao dao = new ShareDaoImpl();

    @Override
    public void perform(String info) {
        String operation = info.split(",")[OPERATION_INDEX];
        Integer size = Integer.valueOf(info.split(",")[SIZE_INDEX]);
        if (Objects.equals(operation, "buy")) {
            dao.updateAsksMap(size);
        } else {
            dao.updateBidsMap(size);
        }
    }
}
