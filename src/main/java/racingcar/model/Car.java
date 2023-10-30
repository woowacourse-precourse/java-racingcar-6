package racingcar.model;

public class Car {
    CarName name;
    int step;

    public Car(String name) {
        this.name = new CarName(name);
        this.step = 0;
    }

    public String getName() {
        return name.get();
    }
    
    public int getStep() {
        return step;
    }

    public void increaseStep() {
        step++;
    }
}
