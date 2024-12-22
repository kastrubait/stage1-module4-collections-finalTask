package com.epam.mjc.collections.combined;

import java.util.*;
import java.util.stream.Collectors;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {

        List<String> projectsDev = new ArrayList<>();

        for(Map.Entry<String, Set<String>> item : projects.entrySet()){
            if (item.getValue().contains(developer)) {
                projectsDev.add(item.getKey());
            }
        }

        projectsDev.sort(Comparator.comparingInt(String::length).reversed()
                .thenComparing(Comparator.reverseOrder()));

        return projectsDev;
    }
}
