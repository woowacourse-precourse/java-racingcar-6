package racingcar.validate;

public class RacingCarValidate {

    public static void validateCarName(String carName) {
        if(carName.isBlank() || carName.length() > 5){
            throw new IllegalArgumentException();
        }
    }
}
