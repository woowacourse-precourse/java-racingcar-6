package racingcar.domain;

public class Race {
    private final NumberGenerator numberGenerator = new NumberGenerator();
    public Race(){}

    public void startRace(Car car){
        if (isAbleToMove()) {
            car.move();
        } else {
            car.stop();
        }
    }

    public boolean isAbleToMove(){
        int randomNumber = numberGenerator.createRandomNumber();
        return randomNumber >= 4;
    }
}
