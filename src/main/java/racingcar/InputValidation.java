package racingcar;

public class InputValidation {

    public static void validateNumberOfCarsRange(int numberOfCars) {
        if(numberOfCars < NumberConst.MIN_NUMBER_OF_CAR && numberOfCars > NumberConst.MAX_NUMBER_OF_CAR) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateSeparator(String userInputCarName) {
        String deleteAllWords = userInputCarName.replaceAll("[가-힣a-zA-Z0-9,]", "");
        if(deleteAllWords.length() != 0) {
            throw new IllegalArgumentException();
        }
    }
}
