package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputData = Console.readLine();
        exceptInputCarNames(inputData);
        return inputData;
    }

    public String inputRaceTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputData = Console.readLine();
        exceptInputRaceTimes(inputData);
        return inputData;
    }

    public void exceptInputCarNames(String inputData) {
        if (Validator.validateInputExist(inputData)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    public void exceptInputRaceTimes(String inputData) {
        if (Validator.validateInputExist(inputData)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        if (Validator.validateInputNotNum(inputData)) {
            throw new IllegalArgumentException("입력값은 정수여야 합니다.");
        }
        if (Validator.validateInputIsZero(inputData)) {
            throw new IllegalArgumentException("입력값은 0이 아니어야 합니다.");
        }
    }

}
