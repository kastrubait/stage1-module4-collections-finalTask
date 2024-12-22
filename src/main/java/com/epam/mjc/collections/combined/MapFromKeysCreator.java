package com.epam.mjc.collections.combined;

import java.util.*;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {
        Map<Integer, Set<String>> resultMap = new HashMap<>();

        for(Map.Entry<String, Integer> item : sourceMap.entrySet()){
            int keySize = item.getKey().length();
            if (!resultMap.containsKey(keySize)) {
                Set<String> values = new HashSet<>();
                values.add(item.getKey());
                resultMap.putIfAbsent(keySize, values);
            } else {
                Set<String> oldValues = resultMap.get(keySize);
                oldValues.add(item.getKey());
                resultMap.replace(keySize, oldValues);
            }
        }

        return resultMap;
    }
}
