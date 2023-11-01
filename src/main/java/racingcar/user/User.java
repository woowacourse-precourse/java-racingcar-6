package racingcar.user;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Car;
import racingcar.game.Referee;
import racingcar.utils.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    private List<String> carNames = new ArrayList<>();
    private int attemptCount;

    Validation validation = new Validation();

    private String input() {
        String input = validation.nullStringInput(Console.readLine().trim());
        return input;
    }

    public void parseCarNamesInput() {
        String input = input();
        String[] arr = input.split(",");
        carNames= validation.carNameInputValidation(Arrays.asList(arr));
    }

    public void attemptCountInput() {
        attemptCount = Integer.parseInt(input());
    }

    public void startRace() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        parseCarNamesInput();
        System.out.println("시도할 횟수는 몇회인가요?");
        attemptCountInput();

        System.out.println("실행 결과");

        List<Car> cars = new ArrayList<>();
        Referee referee = new Referee();

        for(String carName: carNames) {
            Car car = new Car(carName, referee);
            cars.add(car);
        }

        referee.runRace(cars, attemptCount);
        System.out.println("최종 우승자 : " + referee.determineWinner());

    }
}
