package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UI {
    Validator validator = new Validator();

    public List<Car> inputCarNames() {

        List<Car> carList = new ArrayList<Car>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesString = Console.readLine();

        validator.carNamesInputValidator(carNamesString);

        String[] eachCarNameString = carNamesString.split(",");

        for (String s: eachCarNameString) {
            Car car = new Car();
            car.setName(s);
            carList.add(car);
        }

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
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
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
