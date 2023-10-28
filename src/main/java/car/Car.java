package car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int location;
    private static final int MOVING_STANDARD = 4;
    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void move(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        this.moveByGivenCondition(randomNumber);
    }

    protected void moveByGivenCondition(int randomValue){
        this.moveByStrategy(() -> randomValue >= MOVING_STANDARD);
    }

    protected void addLocation(){
        this.location++;
    }

    protected void moveByStrategy(MovingStrategy movingStrategy){
        if (movingStrategy.move()){
            this.addLocation();
        }
    }
}
