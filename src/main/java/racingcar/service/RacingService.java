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

        System.out.println();
        System.out.println("실행 결과");

        play();
        
        System.out.println("최종 우승자 : " + getResult());
    }

    private String getResult() {

        Referee referee = new Referee();

        return referee.selectWinner(cars);
    }

    private void play() {
        for (int i = 0; i < tryNum; i++) {
            carsTryMove();
        }
    }

    private void carsTryMove() {

        for (Car car : cars) {
            boolean isMoveCondition = car.isMoveCondition();
            car.move(isMoveCondition);
        }

        System.out.println();
    }

    private void getUserInput() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        String tryNum = Console.readLine();

        List<String> carNameList = List.of(carNames.split(","));
        for (String carName : carNameList) {
            cars.add(new Car(carName));
        }

        this.tryNum = Integer.parseInt(tryNum);
    }
}
