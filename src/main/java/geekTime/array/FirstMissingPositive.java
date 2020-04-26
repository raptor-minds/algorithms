package geekTime.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums){
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] {1,2,0}));

        List<Artist> artistList = new ArrayList<Artist>();
        artistList.add(new Artist("a"));
        artistList.add(new Artist("b"));
        artistList.add(new Artist("c"));
        String names = artistList.stream().map(Artist::getName).collect(Collectors.joining(",", "[", "]"));
        System.out.println(names);
    }

    private static class Artist{
        private String name;

        public Artist(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
