package racingcar.input;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public List<String> carNames = new ArrayList<>();
    public int iterationNumber;

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = List.of(Console.readLine().split(","));

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }

    public int getIterationNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            iterationNumber = Integer.parseInt(Console.readLine());
            return iterationNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
