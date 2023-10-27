package racingcar.model;

public class Car {
    private final String name;
    private int moved;
    private Car(String name) {
        this.name = name;
    }
    public static Car generateCar(String name) {
        return new Car(name);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append(String.format("%s : ", name));
        print.append("-".repeat(moved));

        return print.toString();
    }
}
