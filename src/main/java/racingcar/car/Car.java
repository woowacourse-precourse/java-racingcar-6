package racingcar.car;

public class Car {
    private Name name;
    private final Engine engine;
    private int travelDistance;

    public Car(String name) {
        this.name = new Name(name);
        this.engine = new Engine();
        this.travelDistance = 0;
    }

    public void move() {
        if(engine.isForward()){
            travelDistance += 1;
        }
    }

}
