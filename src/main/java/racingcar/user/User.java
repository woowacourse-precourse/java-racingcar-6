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
        String str = Console.readLine().trim();
        return validation.nullStringInput(str);
    }

    private void operate(Referee referee, List<Car> cars) {
        referee.runRace(cars, attemptCount);
        System.out.println("최종 우승자 : " + referee.determineWinner());
    }

    public void parseCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = input();
        String[] arr = input.split(",");
        carNames = validation.carNameValidator(Arrays.asList(arr));
    }

    public void attemptCountInput() {
        try {
            System.out.println("시도할 횟수는 몇회인가요?");
            int num = Integer.parseInt(input());
            attemptCount = validation.assertNonPositive(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public void startRace() {

        parseCarNamesInput();
        attemptCountInput();
        System.out.println("실행 결과");

        List<Car> cars = new ArrayList<>();
        Referee referee = new Referee();

        for (String carName : carNames) {
            Car car = new Car(carName, referee);
            cars.add(car);
        }
        operate(referee, cars);
    }
}
