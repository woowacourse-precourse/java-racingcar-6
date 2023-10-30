package racingcar;

public class Car {
    private String carName;
    private int distance;
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
        return 0;
    }

    private int goOrStop(int randomNumber){
        return 0;
    }

    private int totalDistance(int step){
        return 0;
    }

    public void printPosition(){}
}
