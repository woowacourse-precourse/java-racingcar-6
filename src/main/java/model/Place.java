package model;

public class Place {
    final static String ONE_PLACE = "-";
    String nowPlace = "";

    public void moveForward() {
        this.nowPlace = this.nowPlace + ONE_PLACE;
    }

    public String getNowPlace() {
        return nowPlace;
    }
}
