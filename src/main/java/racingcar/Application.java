package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Application {
    private static List<Car> transformStringToCarList(String cars) {
        List<Car> carList = new ArrayList<Car>();
        for (String carName : Arrays.stream(cars.split(",")).toList()) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }

            final Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final List<Car> cars = transformStringToCarList(Console.readLine());
        System.out.println("시도할 회수는 몇회인가요?");

        int turn = Integer.parseInt(Console.readLine());
        int maxScore = 0;

        System.out.println("실행 결과");
        for (int i = 0; i < turn; i++) {
            maxScore = cars.stream().mapToInt(Car::run).max().orElse(0);
            System.out.println();
        }
    }
}
