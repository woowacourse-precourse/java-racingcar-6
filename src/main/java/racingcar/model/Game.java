package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {
    private final List<Car> carList = new ArrayList<>();
    private final Integer count;
    private final StringBuilder gameLog = new StringBuilder();

    public Game(String carNames, String count) {
        Arrays.stream(carNames.split(",")).forEach(carName -> carList.add(new Car(carName)));
        this.count = Integer.parseInt(count);
    }

    public StringBuilder run() {
        for (int i = 0; i < count; i++) {
            race();
            moveStatePrint();
        }
        gameResultPrint();
        return gameLog;
    }

    private void race() {
        for (Car car : carList) {
            Integer randomValue = Randoms.pickNumberInRange(0, 9);
            carMove(car, randomValue);
        }
    }

    private void carMove(Car car, Integer randomValue) {
        if(randomValue >= 4) {
            car.move();
        }
    }

    private void moveStatePrint() {
        for (Car car : carList) {
            gameLog.append(car.getName() + " : " + car.getMoveState() + "\n");
        }
        gameLog.append("\n");
    }

    private void gameResultPrint() {
        String result = "";
        Collections.sort(carList, (Car o1, Car o2) -> o2.getMoveState().length() - o1.getMoveState().length());

        String moveState = carList.get(0).getMoveState();
        for(Car car : carList) {
            if (car.getMoveState().equals(moveState)) {
                result += ", " + car.getName();
            }
        }

        gameLog.append("최종 우승자 : " + result.substring(2));
    }
}
