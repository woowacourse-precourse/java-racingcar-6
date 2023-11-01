package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    static final int MOVING_CONDITION = 4;
    private static final int NAME_LENGTH = 5;

    public static void main(String[] args) {
        List<Car> cars = Cars();
        int rounds = Rounds();

        System.out.println("\n실행 결과");
        for (int i = 0; i < rounds; i++) {
            cars.forEach(car -> car.Move(Randoms.pickNumberInRange(0, 9)));
            cars.forEach(System.out::println);
            System.out.println();
        }

        List<String> winners = Winners(cars);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private static List<Car> Cars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String inputNames = Console.readLine();

        return Arrays.stream(inputNames.split(","))
                .map(String::trim)
                .map(name -> {
                    if (name.length() > NAME_LENGTH) throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
                    return new Car(name);
                })
                .collect(Collectors.toList());
    }

    private static int Rounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        try {
            return Integer.parseInt(Console.readLine());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 다시 입력해주세요.");
        }

    }

    static List<String> Winners(List<Car> cars) {
        int maxPosition = cars.stream().max(Comparator.comparingInt(Car::getPosition)).get().getPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}