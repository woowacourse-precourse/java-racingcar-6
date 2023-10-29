package racingcar.Input;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public List<String> carNames = new ArrayList<>();
    public int IterationNumber;

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = List.of(Console.readLine().split(","));

        for (String carName : carNames) {
            if (carName.length() > 5)
                throw new IllegalArgumentException();
        }
        return carNames;
    }

    public int getIterationNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            IterationNumber = Integer.parseInt(Console.readLine());
            return IterationNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
