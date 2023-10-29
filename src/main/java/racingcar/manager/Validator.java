package racingcar.manager;

public class Validator {

    public int validateGameRound(String input2) throws IllegalArgumentException {
        return Integer.parseInt(input2);
    }

    public void validateCarName(String carName) {
        validateCarNameLength(carName);
        throwErrorIfCarNameHasBlank(carName);
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이 5보다 큽니다.");
        }
    }

    private void throwErrorIfCarNameHasBlank(String carName){
        if (carName.contains(" ")){
            throw new IllegalArgumentException("자동차 이름에 공백이 존재합니다.");
        }
    }
}