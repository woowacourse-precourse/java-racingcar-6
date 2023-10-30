package car;

import camp.nextstep.edu.missionutils.Randoms;

import static validate.InputValidation.*;

public class Car {
    private int distance;
    private final String name;

    public Car(String name){
        nameValidate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private int getRandomNumberBetweenZeroAndNine() {
        return Randoms.pickNumberInRange(0,9);
    }

    public void movingForward() {
        int randomNumber = getRandomNumberBetweenZeroAndNine();
        if (randomNumber >= 4){
            distance++;
        }
    }

    private void nameValidate(String name) {
        validateInputLengthExceeded(name);
        validateInputIsEmpty(name);
        validateInputDoesNotContainSpecialCharacters(name);
    }
}
