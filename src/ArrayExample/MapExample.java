package ArrayExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MapExample {

    public static void main(String[] args) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> Johnsongs = new ArrayList<>();
        Johnsongs.add("song1");
        Johnsongs.add("song2");
        Johnsongs.add("song3");
        Johnsongs.add("song4");
        Johnsongs.add("song8");
        map.put("john", Johnsongs);
        List<String> JyotsnaSong = new ArrayList<>();
        JyotsnaSong.add("song5");
        JyotsnaSong.add("song6");
        JyotsnaSong.add("song7");
        map.put("jyotsna", JyotsnaSong);
        HashMap<String, List<String>> map1 = new HashMap<>();
        List<String> songsType = new ArrayList<>();
        songsType.add("song1");
        songsType.add("song3");
        map1.put("Rock", songsType);
        List<String> songsType2 = new ArrayList<>();
        songsType2.add("song3");
        songsType2.add("song4");
        map1.put("Dubsteb", songsType2);
        map1.put("Techno", Arrays.asList("song2", "song4"));
        map1.put("Pop", Arrays.asList("song5", "song6"));

        HashMap<String, List<String>> map3 = new HashMap<>();
        map.entrySet().stream().forEach(stringListEntry -> {
            List<String> type = new ArrayList<>();
            map1.forEach((s, strings) -> {
                if (stringListEntry.getValue().containsAll(strings)) {
                    type.add(s);
                }
            });
            map3.put(stringListEntry.getKey(), type);
        });
        map3.entrySet().stream().forEach(System.out::println);
    }


}
