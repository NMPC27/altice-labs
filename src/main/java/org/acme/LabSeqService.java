package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class LabSeqService {
    private static Map<Integer, Integer> cache = new HashMap<>(); // ter um it que me diz o max number

    static {
        cache.put(0, 0);
        cache.put(1, 1);
        cache.put(2, 0);
        cache.put(3, 1);
    }

    public static Integer labseq(String num) {
        int n = 0;

        try {
            n = Integer.valueOf(num);
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer input");
            return null;
        }

        if (n < 0) {
            System.out.println("It must be a non negative integer");
            return null;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int curr_n = 4;
        for (int i = n; i > 3; i--) {
            if (cache.containsKey(i)) {
                curr_n = i + 1;
                break;
            }
        }

        for (int i = curr_n; i <= n; i++) {
            int next = cache.get(i - 4) + cache.get(i - 3);
            cache.put(i, next);
        }

        return cache.get(n);
    }

}