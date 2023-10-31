package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> carList;
    private final Referee referee;

    public RacingGame() {
        this.carList = null;
        this.referee = new Referee();
    }

    public void getCars(List<String> carNames) {
        this.carList = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public List<String> getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String readLine = Console.readLine();
        return List.of(readLine.split(","));
    }
}
