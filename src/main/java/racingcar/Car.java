package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private int distance = 0;
    public Car(String carName) {
        this.carName = carName;
    }

    public void move(){
        int randomNumber = getRandomNumber();
        int step = goOrStop(randomNumber);
        distance = totalDistance(step);
        printPosition();
    }

    private int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    private int goOrStop(int randomNumber){
        int step;
        if (randomNumber >= 4){
            step = 1;
        }else{
            step = 0;
        }
        return step;
    }

    private int totalDistance(int step){
        return distance + step;
    }

    public void printPosition(){}
}
