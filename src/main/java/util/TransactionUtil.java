package util;

public interface TransactionUtil {
    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();

}
