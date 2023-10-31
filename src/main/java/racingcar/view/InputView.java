package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    String readLine;

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        readLine = Console.readLine();
        String[] carNames = readLine.split(",");

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        return List.of(carNames);
    }

    public int getTrials() {
        System.out.println("시도할 회수는 몇회인가요?");
        readLine = Console.readLine();

        if (!readLine.matches("\\d+")) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(readLine);
    }
}
