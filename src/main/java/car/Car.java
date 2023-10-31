package car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int location;

    private static final int MOVING_STANDARD = 4;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    private void addLocation(){
        this.location++;
    }

    public void move(){
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        this.moveByGivenCondition(randomNumber);
    }

    protected void moveByGivenCondition(int randomValue){
        this.moveByStrategy(() -> randomValue >= MOVING_STANDARD);
    }

    protected void moveByStrategy(MovingStrategy movingStrategy){
        if (movingStrategy.move()){
            this.addLocation();
        }
    }
}
