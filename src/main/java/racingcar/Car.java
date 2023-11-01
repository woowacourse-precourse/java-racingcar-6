package racingcar;

import java.util.ArrayList;
import java.util.List;
public class Car {
    private String name;
    private int position;

    Car(String name) {
        setName(name);
        position = 0;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void move() {
        this.position++;
    }
    public void printCarPosition() {
        System.out.printf("%s : ", name);
        for (int i = 0; i < position; i++)
            System.out.print("-");
        System.out.println();
    }
    public int compareCarPosition(Car nowMaxCar) {
        return Integer.compare(this.position, nowMaxCar.position);
    }
    public void printCarName() {
        System.out.print(name);
    }
    public String getName() { // getName을 안 쓰고 해결하는 방법을 찾고 싶다
        return name;
    }
}