package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
public class Driver {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private Name name;
    private int score;
    private Car car;

    private Driver(String name, Car car){
        this.name = Name.of(name);
        this.score = 0;
        this.car = car;
    }

    public static Driver of(String name, Car car){
        return new Driver(name, car);
    }

    public void drive() {
        int drivingDistance = car.respondToDriverInput(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER));
        this.score += drivingDistance;
    }

    public String getName(){
        return this.name.getName();
    }

    public int getScore(){
        return this.score;
    }
}
