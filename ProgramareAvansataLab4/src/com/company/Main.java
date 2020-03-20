package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        var r = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident("R" + i) )
                .toArray(Resident[]::new);
        List<Resident> residentList = new ArrayList<>(Arrays.asList(r));
        List<Resident> newSortedList = residentList.stream()
                .sorted(Comparator.comparing(Resident::getName))
                .collect(Collectors.toList());
        var h = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Hospital("H" + i, i) )
                .toArray(Hospital[]::new);
        List<Hospital> hospitalList = new ArrayList<>(Arrays.asList(h));

        Map<Resident, List<Hospital>> resPrefMap = new HashMap<>();
        Map<Hospital, List<Resident>> hosPrefMap = new HashMap<>();

        resPrefMap.put(r[0], Arrays.asList(h[0], h[1], h[2]));
        resPrefMap.put(r[1], Arrays.asList(h[0], h[1], h[2]));
        resPrefMap.put(r[2], Arrays.asList(h[0], h[1]));
        resPrefMap.put(r[3], Arrays.asList(h[0], h[2]));

        hosPrefMap.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        hosPrefMap.put(h[1], Arrays.asList(r[0], r[2], r[1]));
        hosPrefMap.put(h[2], Arrays.asList(r[0], r[1], r[3]));

        residentList.stream()
                .filter(res -> resPrefMap.get(res).contains(h[0]))
                .forEach(System.out::println);

        List<Hospital> target = Arrays.asList(h[0], h[2]);

        List<Resident> residentResult = residentList.stream()
                .filter(res -> resPrefMap.get(res).containsAll(target))
                .collect(Collectors.toList());

        List<Hospital> hospitalResult = hospitalList.stream()
                .filter(hosPrefMap::containsKey)
                .filter(hos -> hosPrefMap.get(hos).size() > 0)
                .filter(hos -> hosPrefMap.get(hos).get(0).equals(r[0]))
                .collect(Collectors.toList());
        System.out.println(residentResult.toString());
        System.out.println(hospitalResult.toString());

        Set<Hospital>  hospitalSet = new TreeSet<Hospital>(hospitalList);
        System.out.println(hospitalSet);
    }
}
