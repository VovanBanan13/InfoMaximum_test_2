import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analysis {
    public void duplicate(List<Item> itemList) {
        HashMap<Item, Integer> map = listToMap(itemList);
        System.out.println("\nКоличество записей: " + itemList.size());
        System.out.println("Количество уникальных записей: " + map.size());

        for (Item key : map.keySet()) {
            if (map.get(key) > 1) {
                System.out.println(key + " ---> " + map.get(key) + " повторений");
            }
        }
    }

    public void showFloor(List<Item> itemList) {
        HashMap<Item, Integer> map = listToMap(itemList);
        System.out.println("\nСколько в каждом городе: 1, 2, 3, 4 и 5 этажных зданий: ");
        for (Item key : map.keySet()) {
            System.out.println("В городе " + key.getCity() + " " + key.getFloor() + "-этажных зданий" + " ---> " + map.get(key) + " записей");
        }
        System.out.println();
    }

    private HashMap<Item, Integer> listToMap(List<Item> itemList) {
        HashMap<Item, Integer> map = new HashMap<>();
        Integer count;
        for (Item it : itemList) {
            count = map.get(it);
            if (count == null) map.put(it, 1);
            else map.put(it, count + 1);
        }
        return map;
    }

    public HashMap<String, HashMap<String, Integer>> listToSet(List<Item> itemList) {
        HashMap<String, Integer> floorMap = new HashMap<>();
        HashMap<String, HashMap<String, Integer>> cityMap = new HashMap<>();

        Integer count;
        HashMap<String, Integer> floorMapCheck;
        Collections.sort(itemList);
        for (Item it : itemList) {
            floorMapCheck = cityMap.get(it.getCity());
            if (floorMapCheck == null) {
                floorMap = new HashMap<>();
                floorMap.put("1-этажных зданий",0);
                floorMap.put("2-этажных зданий",0);
                floorMap.put("3-этажных зданий",0);
                floorMap.put("4-этажных зданий",0);
                floorMap.put("5-этажных зданий",0);
                cityMap.put(it.getCity(), floorMap);
            }

            count = cityMap.get(it.getCity()).get(it.getFloorString().concat("-этажных зданий"));
            floorMap.put(it.getFloorString().concat("-этажных зданий"), count + 1);
            cityMap.put(it.getCity(), floorMap);
        }

        System.out.println();
        for (Map.Entry str : cityMap.entrySet()) {
            System.out.println("В городе " + str.getKey().toString() + " " + str.getValue().toString());
        }
        System.out.println();

        return cityMap;
    }
}
