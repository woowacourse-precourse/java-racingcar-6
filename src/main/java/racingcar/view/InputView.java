package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void printInputCarsNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputTotalRoundMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public String inputCarsName() {
        printInputCarsNameMessage();
        return Console.readLine();
    }

    public int inputTotalRound() {
        printInputTotalRoundMessage();
        String totalRound = Console.readLine();
        validateTotalRound(totalRound);
        return Integer.parseInt(totalRound);
    }

    private void validateTotalRound(String inputValue) {
        if (isBlank(inputValue) || isNotNumeric(inputValue)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotNumeric(String inputValue) {
        return !inputValue.chars()
                .allMatch(Character::isDigit);
    }

    private boolean isBlank(String inputValue) {
        return inputValue == null || inputValue.isBlank();
    }
}
