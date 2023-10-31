package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class InputProcessor {
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String readLine = Console.readLine();
        return List.of(readLine.split(","));
    }


    public List<Car> getCars(List<String> carNames) {
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public Integer getRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        String readLine = Console.readLine();
        return Integer.parseInt(readLine);
    }
}
