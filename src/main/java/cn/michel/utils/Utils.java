package cn.michel.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;

public class Utils {

    public static String getAllThreadDumps() {
        ThreadInfo[] threads = ManagementFactory.getThreadMXBean().dumpAllThreads(true, true);
        StringBuilder builder = new StringBuilder();
        for (ThreadInfo info : threads) {
            builder.append('\n').append(info);
        }
        return builder.toString();
    }
}
