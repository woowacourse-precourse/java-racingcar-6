package racingcar.v3;

import camp.nextstep.edu.missionutils.Console;

public class CreateCar {
    public String input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input;
    }

    public String[] splitCarNames(String input) {
        String[] carNames = input.split(",");
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
        return carNames;
    }


    public String[] validateCarNames(String[] carNames) throws IllegalArgumentException {
        validateCarCount(carNames);
        validateCarNameLength(carNames);
        return carNames;
    }

    public void validateCarCount(String[] carNames) throws IllegalArgumentException {
        if (carNames.length < 2 || carNames.length > 10) {
            throw new IllegalArgumentException("자동차의 수는 2대 이상 10대 이하만 가능합니다.");
        }
    }

    public void validateCarNameLength(String[] carNames) throws IllegalArgumentException {
        for (String carName : carNames) {
            if (carName.length() == 0 || carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

}
