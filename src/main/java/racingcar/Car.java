package racingcar;

public class Car {

    NumberGenerator numberGenerator = new NumberGenerator();
    Judgement judgement = new Judgement();
    String carName;
    int pickedNumber;
    int movement = 0;

    public Car(String inputName) {
        carName = inputName;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarMovement() {
        return movement;
    }

    public void pickRandomNumber() {
        pickedNumber = numberGenerator.createRandomNumber();
        judgeStopOrGo(pickedNumber);
    }

    public void judgeStopOrGo(int pickedNumber) {
        if (judgement.isOverFour(pickedNumber)) {
            movement += 1;
        }
    }
}
