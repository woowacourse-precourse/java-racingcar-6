package racingcar;

import java.util.List;

public class InputException {
    static final String MAX_LENGTH_NAME = "자동차의 이름이 5자 초과입니다.";
    static final String BLANK_NAME = "이름이 공백 뿐입니다.";
    static final String SAME_NAME = "같은 이름을 가지고 있습니다.";
    static final String NOT_INTEGER = "입력한 내용이 숫자가 아닙니다.";
    static final String NEGATIVE_OR_ZERO = "입력한 숫자가 0이나 음수입니다.";

    static void exceptionCheckName(String name, List<Car> racingCars) throws IllegalArgumentException {
        String compareName = name.trim();
        if(compareName.isEmpty()) {
            throw new IllegalArgumentException(InputException.BLANK_NAME);
        }
        if(compareName.length() > ConstantNumber.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(InputException.MAX_LENGTH_NAME);
        }
        if(racingCars.stream().anyMatch(car -> car.name.equals(compareName))){
            throw new IllegalArgumentException(InputException.SAME_NAME);
        }
    }

    static int exceptionCheckStep(String step) throws IllegalArgumentException {
        int stepNum;
        try {
            stepNum = Integer.parseInt(step);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(InputException.NOT_INTEGER);
        }
        if(stepNum <= 0) {
            throw new IllegalArgumentException(InputException.NEGATIVE_OR_ZERO);
        }
        return stepNum;
    }
}
