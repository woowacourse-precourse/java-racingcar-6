package racingcar.domain.car;

public class Car {
    private static final int TRAVEL_DISTANCE = 0;
    private static final int TRAVEL_DISTANCE_INCREMENT = 1;

    private final Name name;
    private final Engine engine;
    private int travelDistance;

    public Car(String name) {
        this.name = new Name(name);
        this.engine = new Engine();
        this.travelDistance = TRAVEL_DISTANCE;
    }

    public void move() {
        if(engine.isForward()){
            travelDistance += TRAVEL_DISTANCE_INCREMENT;
        }
    }

    public String getName() {
        return name.getValue();
    }

    public int getTravelDistance() {
        return travelDistance;
    }

}
