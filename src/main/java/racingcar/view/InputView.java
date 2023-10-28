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
        String carsName = Console.readLine();
        validateNull(carsName);
        return carsName;
    }

    public int inputTotalRound() {
        printInputTotalRoundMessage();
        String totalRound = Console.readLine();
        validateNull(totalRound);
        validateNumeric(totalRound);
        return Integer.parseInt(totalRound);
    }

    private void validateNull(String inputValue) {
        if (isBlank(inputValue)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumeric(String inputValue) {
        if (isNotNumeric(inputValue)) {
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
