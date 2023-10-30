package car;

import camp.nextstep.edu.missionutils.Randoms;

import static validate.InputValidation.*;

public class Car {
    public int distance;
    public String name;

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

    public int getRandomNumberBetweenZeroAndNine() {
        return Randoms.pickNumberInRange(0,9);
    }

    public void movingForward() {
        int randomNumber = getRandomNumberBetweenZeroAndNine();
        if (randomNumber >= 4){
            distance++;
        }
    }

    public void nameValidate(String name) {
        validateInputLengthExceeded(name);
        validateInputIsEmpty(name);
        validateInputDoseNotContainSpecialCharacters(name);
    }
}
