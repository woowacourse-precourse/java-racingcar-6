package racingcar.model;

public class Validator {
    public Validator() {
    }

    public boolean isCarNameFromPlayerValidate(String carName) {
        String[] carNameArray = carName.split(",");
        for (int i = 0; i < carNameArray.length; i++) {
            if (!(carNameArray[i].length() <= 5)) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    public boolean isNumberFromPlayerValidate(String number) {
        try {
            int attemptNumber = Integer.parseInt(number);
            return true;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
