package com.hsq;


import com.hsq.dsc.utils.ID;
import com.hsq.dsc.utils.JvmCache;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public class IDTest {
    public static void main(String[] args) throws Exception {
        long times = System.currentTimeMillis();
        ID idWorker = ID.getInstance();
        JvmCache instance = JvmCache.getInstance();
        long query = 0L;
        for (int i = 0; i < 1000000; i++) {
            long a = idWorker.nextId();
            if (i == 99999) {
                query = a;
            }
            instance.set(String.valueOf(a));
        }
        System.out.println(instance.size());
        System.out.println(instance.hasExist(String.valueOf(query)));
        Thread.sleep(3000);
        System.out.println(instance.hasExist(String.valueOf(query)));
        System.err.println("耗时" + (System.currentTimeMillis() - times) + "ms");
    }
}
