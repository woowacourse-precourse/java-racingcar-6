package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car implements Comparable<Car>{
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MOVE_THRESHOLD = 4;
    private String name;
    private StringBuilder moveHyphens;

    public Car(String name){
        this.name = name;
        moveHyphens = new StringBuilder();
    }

    public void tryMoving(){
        int randomNumber =  pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        if (randomNumber >= MOVE_THRESHOLD){
            this.moveHyphens.append("-");
        }
    }

    @Override
    public String toString() {
        return name + " : " + moveHyphens.toString();
    }


    @Override
    public int compareTo(Car comparedCar) {
        return this.getMoveCount() - comparedCar.getMoveCount();
    }

    public int getMoveCount(){
        return moveHyphens.length();
    }
}
