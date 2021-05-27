package com.osms.util;

import java.util.List;

public class IDGenerator {
	
	public static String generateIDs(List<String> arrayList , String prefix) {

        String id;
        int next = arrayList.size();
        System.out.println(next);
        next++;
        id = prefix + next;
        while (arrayList.contains(id)) {
            next++;
            id = prefix + next;
        }
        return id;
    }

}
