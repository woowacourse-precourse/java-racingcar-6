package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private List<Car> carList = new ArrayList<>();
    private List<String> carNames = new ArrayList<>();
    private UserInput userInput = new UserInput();
    private GameResult gameResult = new GameResult();
    private int attemptCount;

    public GameController() {
    }

    public void playGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = userInput.input();
        updateName(names);
        System.out.println("시도할 회수는 몇회인가요?");
        String count = userInput.input();
        System.out.println();
        System.out.println("실행 결과");
        updatePosition(count);
        gameResult.findWinner(carList);
    }

    public void updateName(String names) {
        carNames = userInput.carName(names);
        for (int carNumber = 0; carNumber < carNames.size(); carNumber++) {
            Car car = new Car(carNames.get(carNumber));
            carList.add(car);
        }
    }

    public void updatePosition(String strCount) {
        int attemptCount = userInput.attemptCount(strCount);
        CarMovement carMovement = new CarMovement();
        for (int count = 0; count < attemptCount; count++) {
            carMovement.movement(carList);
            gameResult.printResult(carList);
        }
    }
}
