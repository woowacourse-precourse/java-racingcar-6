package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {


    public List<String> askName() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        List<String> carNames = splitName(inputName);
        checkStringValid(carNames);
        return carNames;
    }

    public int askGameCount() throws IllegalArgumentException {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(Console.readLine());

        } catch (NumberFormatException e) {
            IllegalArgumentException iae = new IllegalArgumentException("숫자를 입력하세요");
            iae.initCause(e);
            throw iae;
        }


    }

    public List<String> splitName(String inputName) {
        return Arrays.asList(inputName.split(","));
    }

    public void checkStringValid(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.isBlank() || carName.length() > 5) {
                throw new IllegalArgumentException("5글자 이하로 공백 없이 입력해 주세요.");
            }

        }
    }
}
