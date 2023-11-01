package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String INPUT_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String BLANK_ERROR_MESSAGE = "공백으로 이루어진 이름은 입력할 수 없습니다.";
    private static final String LENGTH_ERROR_MESSAGE = "5글자가 넘는 이름은 입력할 수 없습니다.";
    private static final String TIMES_REQUEST_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String NUMBER_ERROR_MESSAGE = "숫자가 아닌 값은 입력할 수 없습니다.";

    public String[] inputCarName() throws IllegalArgumentException {
        System.out.println(INPUT_REQUEST_MESSAGE);
        String carName = Console.readLine();
        return checkCarNameLength(carName);
    }

    public String[] checkCarNameLength(String carName) {
        String[] carNames = carName.split(",");
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].isBlank()) throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
            if (carNames[i].length() > MAXIMUM_NAME_LENGTH) throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
        return carNames;
    }

    public int inputNumberTimes() throws IllegalArgumentException {
        System.out.println(TIMES_REQUEST_MESSAGE);
        String inputTimes = Console.readLine();
        return checkNumberException(inputTimes);
    }

    public int checkNumberException(String inputTimes) {
        try {
            int numberTimes = Integer.parseInt(inputTimes);
            return numberTimes;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

}
