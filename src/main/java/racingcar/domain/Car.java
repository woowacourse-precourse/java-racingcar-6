package racingcar.domain;

public class Car {

    private String name;
    private StringBuilder distnace;

    public Car(String name) {
        this.name = name;
        this.distnace = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public StringBuilder getDistnace() {
        return distnace;
    }

    public void moveOrStop() {
        final int MIN_RANGE = 4;
        NumberGenerator numberGenerator = new NumberGenerator();
        int randomNumber = numberGenerator.createRandomNumber();
        if (randomNumber >= MIN_RANGE) {
            distnace.append("-");
        }
    }
}
