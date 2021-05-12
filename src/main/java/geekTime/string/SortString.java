package geekTime.string;

import java.util.*;

public class SortString {

    public String sort(String str) {
        char[] chars = str.toCharArray();
        StringBuilder s = new StringBuilder();
        sortChars(chars);
        for (char aChar : chars) {
            s.append(aChar);
        }
        return s.toString();
    }

    private void sortChars(char[] chars) {
        List<Character> characters = new ArrayList<>(chars.length);
        for (char aChar : chars) {
            characters.add(aChar);
        }
        characters.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < chars.length; i++) {
            chars[i] = characters.get(i);
        }
    }

    public static void main(String[] args) {
        String s = "hello ru cheng";
        System.out.println(new SortString().sort(s));
    }
}
