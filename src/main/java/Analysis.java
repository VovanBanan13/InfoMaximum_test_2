import java.util.HashMap;
import java.util.List;

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
}
