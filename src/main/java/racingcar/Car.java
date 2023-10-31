package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String carName;
    private int distance = 0;
    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName(){
        return carName;
    }

    public int getDistance(){
        return distance;
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

    public void printPosition(){
        String distanceString = "";
        for (int i=0; i<distance; i++){
            distanceString += "-";
        }
        System.out.print(carName + " : " + distanceString + "\n");
    }
}
