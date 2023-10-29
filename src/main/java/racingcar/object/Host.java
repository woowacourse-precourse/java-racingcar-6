package racingcar.object;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Host {
    private List<Car> cars = new ArrayList<>();

    private Integer attemptCount = 0;

    public void inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames;
        carNames = readLine();
        String[] carNamesArray = carNames.split(",");
        for (String s : carNamesArray) {
            cars.add(new Car(s, ""));
        }
    }
}
