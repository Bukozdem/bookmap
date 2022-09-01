package bookmap.handlers;

import bookmap.dao.ShareDao;
import bookmap.dao.ShareDaoImpl;
import bookmap.service.Writer;
import bookmap.service.WriterImpl;
import java.util.Objects;

public class QueryHandler implements OperationHandler {
    private static final int PRICE_INDEX = 1;
    private static final ShareDao dao = new ShareDaoImpl();
    private final Writer writer = new WriterImpl();

    @Override
    public void perform(String info) {
        if (Objects.equals(info, "best_bid")) {
            writer.write(dao.getBestBid());
        } else if (Objects.equals(info, "best_ask")) {
            writer.write(dao.getBestAsk());
        } else {
            writer.write(dao.getSizeByPrice(Integer.valueOf(info.split(",")[PRICE_INDEX])));
        }
    }
}
