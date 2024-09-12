package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputProcessor {
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        try {
            String readLine = Console.readLine();
            return List.of(readLine.split(","));
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Car> getCars(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }

    public Integer getRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            String readLine = Console.readLine();
            int parseInt = Integer.parseInt(readLine);
            checkRoundValue(parseInt);
            return parseInt;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRoundValue(Integer input) {
        if (input < 1) {
            throw new IllegalArgumentException();
        }
    }
}
