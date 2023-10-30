package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
public class Driver {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private Name name;
    private int score;
    private Car car;

    public Driver(String name){
        this.name = new Name(name);
        this.score = 0;
        this.car = new Car();
    }

    public static Driver of(String name){
        if (name.length() > 5){
            throw new IllegalArgumentException("이름은 5글자 이하");
        }
        return new Driver(name);
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
