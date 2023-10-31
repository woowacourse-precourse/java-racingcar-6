package racingcar.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class InputController {
    private int attemptCount;

    public int getAttemptCount() {
        return attemptCount;
    }

    public String insertCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String carNames = readLine();
        return carNames;
    }

    public List<Car> setCar(String carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            nameLengthCheck(carName);
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    private void nameLengthCheck(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자이하이고 여러개라면 쉽표(,)로 구분해야 합니다.");
        }
    }

    public void insertAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        this.attemptCount = Integer.parseInt(readLine());
    }
}
