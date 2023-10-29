package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<String> names = getCarNames();

        List<Car> carList = createCars(names);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputNumber = Console.readLine();
        int attemptsNumber;
        try {
            attemptsNumber = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자만 가능합니다.");
        }

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < attemptsNumber; i++) {
            racing(carList);
            System.out.println();
        }
        List<String> result = winners(carList);
        String winners = String.join(",", result);
        System.out.println("최종 우승자 : " + winners);
    }

    private static List<Car> createCars(List<String> names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            validateName(name);
            carList.add(new Car(name));
        }
        return carList;
    }

    private static void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    private static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        return Arrays.asList(inputName.split(","));
    }

    private static void racing(List<Car> carList) {
        for (Car car : carList) {
            if (shouldMove()) car.move();
            System.out.println(car.printCarName());
        }
    }

    private static boolean shouldMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    private static List<String> winners(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getPositionLength)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPositionLength() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
