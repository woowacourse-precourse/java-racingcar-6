package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Referee;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    private final List<Car> cars = new ArrayList<>();
    private int tryNum;

    public RacingService() {

    }

    public void race() {
        getUserInput();
        play();
        System.out.println("최종 우승자 : " + getResult());
    }

    private String getResult() {
        Referee referee = new Referee();
        return referee.selectWinner(cars);
    }

    private void play() {
        for(int i=0; i<tryNum; i++) {
            for (Car car : cars) {
                boolean isMoveCondition = car.isMoveCondition();
                car.move(isMoveCondition);
            }
        }
    }

    private void getUserInput() {
        String carNames = Console.readLine();
        String tryNum = Console.readLine();
        List<String> carNameList = List.of(carNames.split(","));
        for (String carName : carNameList) {
            cars.add(new Car(carName));
        }
        this.tryNum = Integer.parseInt(tryNum);
    }
}
