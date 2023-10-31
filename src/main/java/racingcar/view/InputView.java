package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsName = Console.readLine();
        return carsName;
    }

    public int readCarMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputString = Console.readLine();
        validateDigit(inputString);
        return Integer.parseInt(inputString);
    }

    private void validateDigit(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
