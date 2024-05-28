package question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, String> map = new HashMap<>();

        previous.stream().forEach(p -> map.put(p.getId(), p.getName()));

        for (User user : current) {
            int id = user.getId();
            String name = user.getName();

            if (!map.containsKey(id)) {
                info.setAdded();
            } else {
                if (!map.get(id).equals(name)) {
                    info.setChanged();
                }
                map.remove(id);
            }
        }
        info.setDeleted(map.size());
        return info;
    }
}