package utils;

import java.util.concurrent.atomic.AtomicInteger;

public class Util {

    static AtomicInteger i = new AtomicInteger(0);

    public static int generateId(){
        return i.incrementAndGet();
    }

}
