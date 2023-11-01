package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final int MIN_BOUND = 0;
    private final int MOVE_BOUND = 4;
    private final int MAX_BOUND = 9;
    private CarName carName;
    private Location location;

    public Car(CarName name) {
        this.carName = name;
        this.location = new Location();
    }

    public void move(){
        if( getRandomNumber() >= MOVE_BOUND ) {
            int currLocation = location.getLocation();
            location = new Location(++currLocation);
        }
    }

    public boolean isWinner(Location maxLocation){
        return location.isMax(maxLocation);
    }

    public CarName getCarName() {
        return carName;
    }

    public Location getLocation() {
        return location;
    }


    public String getCarNameValue() {
        return carName.getName();
    }

    public int getLocationValue(){
        return location.getLocation();
    }

    protected int getRandomNumber(){
        return Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND);
    }
}
