package racingcar;

public class InputValidation {

    public static void validateNumberOfCarsRange(int numberOfCars) {
        if(numberOfCars < NumberConst.MIN_NUMBER && numberOfCars > NumberConst.CAR_MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

}
