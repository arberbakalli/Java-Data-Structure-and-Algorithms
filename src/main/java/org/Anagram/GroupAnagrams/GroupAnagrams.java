package org.Anagram.GroupAnagrams;

import org.Anagram.EdgeCase;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();

        String[] strs = {"act","pots","tops","cat","stop","hat"};

        List<List<String>> result = new ArrayList<>();

        System.out.println(groupAnagrams.groupAnagrams(strs));

    }

    public boolean isAnagram(String s,String t){
        if(s.length() != t.length()) return false;
        HashMap<Character,Integer> map_s = new HashMap<>();
        HashMap<Character,Integer> map_t = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map_s.put(s.charAt(i), map_s.getOrDefault(s.charAt(i), 0) + 1);
            map_t.put(t.charAt(i), map_t.getOrDefault(t.charAt(i), 0) + 1);
        }

        return map_s.equals(map_t);
    }

    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> result = new HashMap<>();

       for(String s: strs){
           char[] charArray = s.toCharArray();
           Arrays.sort(charArray);
           String sortedS = new String(charArray);
           result.putIfAbsent(sortedS, new ArrayList<>());
              result.get(sortedS).add(s);
       }
        return new ArrayList<>(result.values());
    }
}