package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Cars {
    private final String[] carNames;

    public Cars() {
        String carNames = Console.readLine();
        nameLengthError(carNames);
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
    
}