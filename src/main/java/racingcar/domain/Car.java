package racingcar.domain;

public class Car {
    private final String name;
    private int step;

    public Car(String name) {
        this.name = name;
        this.step = 0;
    }

    public void stepForward() {
        this.step++;
    }

    public void printStepState() {
        System.out.print(this.name + " : ");
        for (int i = 0; i< this.step; i++)
            System.out.print("-");
        System.out.println();
    }

    public void printName() {
        System.out.print(this.name);
    }

    public int getStep() {
        return this.step;
    }
}
