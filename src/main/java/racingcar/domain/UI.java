package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UI {

    private Validator validator = null;

    public UI(Validator validator) {
        this.validator = validator;
    }

    public List<Car> inputCarNames() {

        List<Car> carList = new ArrayList<Car>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesString = Console.readLine();

        validator.carNamesInputValidator(carNamesString);

        Arrays.stream(carNamesString.split(",")).forEach(carName -> {
            Car car = new Car();
            car.setName(carName);
            carList.add(car);
        });

        return carList;
    }

    public int inputRounds() {
        int maxRounds = 0;

        System.out.println("시도할 회수는 몇회인가요?");
        String maxRoundString = Console.readLine();

        validator.roundsInputValidator(maxRoundString);
        maxRounds = Integer.parseInt(maxRoundString);

        return maxRounds;
    }

    public void showResult(List<Car> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName() + " : ");
            System.out.print("-".repeat(car.getPosition()));
            System.out.println();
        });
        System.out.println();
    }

    public void showFinalResult(List<Car> cars) {
        List<String> winnerList = new ArrayList<String>();
        int maxPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.print(winnerList.get(i));
            if (i != winnerList.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
