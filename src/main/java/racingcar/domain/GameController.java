package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private List<Car> carList = new ArrayList<>();
    private UserInput userInput = new UserInput();
    private List<String> carNames = new ArrayList<>();

    public GameController() {
    }

    public void playGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = userInput.input();
        updateName(names);
    }

    public void updateName(String names) {
        carNames = userInput.carName(names);
        for (int i = 0; i < carNames.size(); i++) {
            Car car = new Car(carNames.get(i));
            carList.add(car);
        }
    }

    public void updatePosition() {
    }
}
