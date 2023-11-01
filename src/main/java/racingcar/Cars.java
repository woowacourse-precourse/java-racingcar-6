package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Cars {
    private final String[] carNames;

    public Cars() {
        String carNames = Console.readLine();
        nameLengthError(carNames);
        emptyError(carNames);
        this.carNames = carNames.split(",");
    }
    public void nameLengthError(String carNames){  //길이가 5글자 이상일 때
        String[] carNamesArray = carNames.split(",");
        for (String oneCarName : carNamesArray) {
            if (oneCarName.length() > 5) {
                throw new IllegalArgumentException(ExceptionError.nameLengthError);
            }
        }
    }

    public void emptyError(String carNames){ // 공백을 입력했을 때
        String[] carNameArray = carNames.split(",");
        for (String oneCarName : carNameArray) {
            if (oneCarName.trim().isEmpty()) {
                throw new IllegalArgumentException(ExceptionError.emptyError);
            }
        }
    }
}