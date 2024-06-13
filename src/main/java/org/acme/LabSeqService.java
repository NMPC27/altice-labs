package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;
import java.math.BigInteger;

@ApplicationScoped
public class LabSeqService {
    private static Map<Integer, BigInteger> cache = new HashMap<>(); 
    private static int maxCache = 3;

    static {
        cache.put(0, BigInteger.ZERO);
        cache.put(1, BigInteger.ONE);
        cache.put(2, BigInteger.ZERO);
        cache.put(3, BigInteger.ONE);
    }

    public static BigInteger labseq(String num) {
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

        if (n <= maxCache) {
            return cache.get(n);
        }

        for (int i = maxCache + 1; i <= n; i++) {
            BigInteger next = cache.get(i - 4).add(cache.get(i - 3));
            cache.put(i, next);
        }

        maxCache = n;

        return cache.get(n);
    }

}