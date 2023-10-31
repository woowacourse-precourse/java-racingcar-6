package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class InputView {

    public List<String> getCarNames() {
        List<String> carNames;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameString = readLine();
        carNames = List.of(carNameString.split(","));
        if (carNames.size() == 0) {
            throw new IllegalArgumentException();
        }

        return carNames;
    }

    public Integer getNumberOfRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        String numberOfRoundString = readLine();
        for (int i = 0; i < numberOfRoundString.length(); ++i) {
            char ch = numberOfRoundString.charAt(i);
            if (ch < '0' || ch > '9') {
                throw new IllegalArgumentException();
            }
        }
        return Integer.valueOf(numberOfRoundString);
    }
}
