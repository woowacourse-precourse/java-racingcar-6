package racingcar;

public class Exception {

    public void ErrorCheck(String carName) {
        String[] carNameArray = carName.split(",");
        for (String name: carNameArray) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("5글자 넘어감");
            }
        }
    }


}

