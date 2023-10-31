package racingcar;

public class Exception {

    private static final int CAR_MAX_LENGTH = 5;
    public void ErrorCheck(String carName) {
        String[] carNameArray = carName.split(",");
        for (String name: carNameArray) {
            if (name.length() > CAR_MAX_LENGTH) {
                throw new IllegalArgumentException("5글자 넘어감");
            }
        }
    }


}

