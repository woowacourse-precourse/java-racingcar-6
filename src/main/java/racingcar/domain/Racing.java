package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Racing {

    private static void checkNameException(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 1~5자로 입력해주세요.");
        }
    }

    private static int isAllowIntString(String turn) {
        try {
            return Integer.parseInt(turn);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }

    private static List<Car> transformStringToCarList(String cars) {
        List<Car> carList = new ArrayList<>();
        for (String carName : Arrays.stream(cars.split(",")).toList()) {
            checkNameException(carName);
            final Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    private void start(List<Car> cars, int turn) {
        int maxScore = 0;

        System.out.println("실행 결과");
        for (int i = 0; i < turn; i++) {
            maxScore = cars.stream().mapToInt(Car::run).max().orElse(0);
            System.out.println();
        }

        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            final String carName = car.ifMaxScore(maxScore);
            if (!carName.isEmpty()) {
                winner.add(carName);
            }
        }
        String winnerFormat = String.format("최종 우승자 : %s", String.join(", ", winner));
        System.out.println(winnerFormat);
    }

    public void ready() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final List<Car> cars = transformStringToCarList(Console.readLine());
        System.out.println("시도할 회수는 몇회인가요?");
        int turn = isAllowIntString(Console.readLine());
        start(cars, turn);
    }
}
