package howard.edu.lsp.finals.problem; 

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SongsDatabase {
private Map<String, HashSet<String>> map = new HashMap<>();

public void addSong(String genre, String songTitle) {
    if (!map.containsKey(genre)) {
        map.put(genre, new HashSet<>());
    }
    map.get(genre).add(songTitle);
}

public Set<String> getSongs(String genre) {
	  return map.getOrDefault(genre, new HashSet<>());
}

public String getGenreOfSong(String songTitle) {
    for (String genre : map.keySet()) {
        if (map.get(genre).contains(songTitle)) {
            return genre;
        }
    }
    return null;
}
}