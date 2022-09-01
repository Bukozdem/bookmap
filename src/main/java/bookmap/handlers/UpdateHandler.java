package bookmap.handlers;

import bookmap.dao.ShareDao;
import bookmap.dao.ShareDaoImpl;
import bookmap.model.Share;
import java.util.Objects;

public class UpdateHandler implements OperationHandler {
    private static final Integer NUMBER_INDEX = 0;
    private static final Integer QUANTITY_INDEX = 1;
    private static final Integer TYPE_INDEX = 2;
    private static final ShareDao dao = new ShareDaoImpl();

    @Override
    public void perform(String info) {
        Share share = new Share(Integer.parseInt(info.split(",")[NUMBER_INDEX]),
                Integer.parseInt(info.split(",")[QUANTITY_INDEX]));
        if (Objects.equals(info.split(",")[TYPE_INDEX], "bid")) {
            dao.addToBidsMap(share.getPrice(), share.getSize());
        } else {
            dao.addToAsksMap(share.getPrice(), share.getSize());
        }
    }
}
