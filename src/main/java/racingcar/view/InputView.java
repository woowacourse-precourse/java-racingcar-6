package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String INPUT_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_ATTEMPT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public void printInputCarsNameMessage() {
        System.out.println(INPUT_CARS_NAME_MESSAGE);
    }

    public void printInputAttemptCountMessage() {
        System.out.println(INPUT_ATTEMPT_COUNT_MESSAGE);
    }
    public String carsName() {
        printInputCarsNameMessage();
        return Console.readLine();
    }

    public int totalRound() {
        printInputAttemptCountMessage();
        String inputRound = Console.readLine();
        if(isNotNumeric(inputRound)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(inputRound);
    }

    private boolean isNotNumeric(String inputValue) {
        return !inputValue.chars()
                .allMatch(Character::isDigit);
    }
}
