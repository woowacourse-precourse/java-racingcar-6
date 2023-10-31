package racingcar;

public class Car {
    final String name;
    int location;

    public Car(String name) {
        checkCarName(name);
        this.name = name;
        this.location = 0;
    }

    public void move(int going) {
        if ((this.location + going)>=0){this.location += going;}
    }

    private void checkCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("name is limited to 5 characters");
        }
    }
}
