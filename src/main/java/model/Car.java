package model;

public class Car {
    final static int FORWARDING_THRESHOLD = 4;
    Name name;
    Place place;

    public Car(String name) {
        this.name = new Name(name);
        this.place = new Place();
    }

    public String getName() {
        return name.getName();
    }


    public String getNowPlace() {
        return place.getNowPlace();
    }

    public void tryMove(int randomNumber) {
        if (randomNumber >= FORWARDING_THRESHOLD) {
            place.moveForward();
        }
    }
}
