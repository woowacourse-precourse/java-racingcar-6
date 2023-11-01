package racingcar.component;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.util.RegexMatcher;

import java.util.LinkedList;
import java.util.List;


public class Cars {
    private List<Car> cars;

    public Cars() {
        cars = new LinkedList<>();
        initCars();
    }

    private List<String> inputNewCarNames() {
        List<String> nameList = new LinkedList<>();
        String names = Console.readLine();

        for (String name : names.split(",")) {
            if (!RegexMatcher.match("^[a-zA-Z]{1,5}$", name)) {
                throw new IllegalArgumentException("이름은 1~5 글자의 영문 대/소문자만 가능합니다.");
            }
            nameList.add(name);
        }
        return nameList;
    }

    private void addCarsByNames(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void initCars() {
        List<String> names;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        names = inputNewCarNames();
        addCarsByNames(names);
    }

    private int totalizeMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public void totalizeWinnersNames() {
        List<String> winners = new LinkedList<>();
        int maxPosition;

        maxPosition = totalizeMaxPosition();
        for (Car car : cars) {
            if (maxPosition == car.getPosition()) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public void runARound() {
        for (Car car : cars) {
            car.moveOrNot();
            car.printPosition();
        }
    }
}
