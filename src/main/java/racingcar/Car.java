package racingcar;

public class Car {
    String name = "";
    Integer position = -1;
    public Car(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public void print() {
        System.out.println(this.name + " : " + "-".repeat(this.position));
    }
}
