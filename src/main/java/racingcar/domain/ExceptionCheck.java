package racingcar.domain;


public class ExceptionCheck {

    private static final Integer NAME_LENGTH_MAX = 5;
    public static void isCarNameInputLengthValidate(String[] carsNameInputArray) throws IllegalArgumentException{

        for (String carName : carsNameInputArray) {
            int carNameLength = carName.length();
            if (carNameLength > NAME_LENGTH_MAX) {
                throw new IllegalArgumentException();
            }
        }
    }
    public static void isRepetitionNumberInputTypeValidate(String repetitionNumberInput) throws IllegalArgumentException{

        try {
            Integer.parseInt(repetitionNumberInput);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void isRepetitionNumberInputRangeValidate(String carsNameInput) throws IllegalArgumentException{

        int validationCheckNumber = Integer.parseInt(carsNameInput);
        if (validationCheckNumber < 0) {
            throw new IllegalArgumentException();
        }
    }
}
