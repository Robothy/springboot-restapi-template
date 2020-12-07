package site.luofuxiang.util;

public class UUIDUtil {

    private static IdWorker idWorker;

    static {
        idWorker = new IdWorker(1, 1);
    }

    public static Long generateUUID(){
        return idWorker.nextId();
    }

}