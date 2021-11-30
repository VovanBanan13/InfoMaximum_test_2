import java.util.Objects;

public class Item implements Comparable<Item>{

    private String city;
    private String street;
    private int house;
    private int floor;

    public String getCity() { return city; }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() { return street; }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() { return house; }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getFloor() { return floor; }

    public String getFloorString() {
        String floorStr = String.valueOf(floor);
        return floorStr;
    }

    public void setFloor(int floor) { this.floor = floor; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return house == item.house && floor == item.floor && Objects.equals(city, item.city) && Objects.equals(street, item.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, house, floor);
    }

    @Override
    public int compareTo(Item o) {
        int result = this.getCity().compareTo(o.getCity());

        if (result == 0)
            result = this.getFloor() - o.getFloor();

        return result;
    }

    @Override
    public String toString() {
        return "\nItem {" +
                "city=" + city  +
                ", street=" + street +
                ", house=" + house +
                ", floor=" + floor +
                '}';
    }
}
