package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> names = Arrays.asList(Console.readLine().split(","));

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = getTryNumber();
        if (tryNumber < 0) {
            throw new IllegalArgumentException("시도 횟수는 0 이상만 가능합니다.");
        }
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < tryNumber; i++) {
            for (Car car : cars) {
                car.move(Randoms.pickNumberInRange(0, 9));
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
            }
            System.out.println();
        }
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == max) {
                winnerCars.add(car);
            }
        }
        StringJoiner joiner = new StringJoiner(", ");
        for (Car car : winnerCars) {
            joiner.add(car.getName());
        }
        System.out.println("최종 우승자 : " + joiner);
    }

    private static int getTryNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 가능합니다.");
        }
    }
}
