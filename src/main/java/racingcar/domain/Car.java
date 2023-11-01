package racingcar.domain;

public class Car {
    public final String name;
    public int forward_count;

    public Car(String name) {
        this.name = name;
        this.forward_count = 0;
    }

    public void printStatus() {
        System.out.print(this.name + " : ");
        for(int i = 0; i < this.forward_count; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public void moveForward() {
        forward_count += 1;
    }

}
