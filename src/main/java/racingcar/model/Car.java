package racingcar.model;

public class Car {
    private String name;
    private int moved = 0;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[Error]: 자동차 이름이 5자를 넘음");
        }
        this.name = name;
    }

    // for test
    public void Test() {
        System.out.println(name + " " + moved);
    }
}
