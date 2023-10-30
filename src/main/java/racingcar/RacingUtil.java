package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingUtil {

    public static List<Car> getCarsList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        boolean isValidateName = Arrays.stream(carNames)
                .anyMatch(name -> name.length() > 5);

        if (isValidateName) {
            throw new IllegalArgumentException();
        }
        ArrayList<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public static int getTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public static void raceStart(List<Car> cars, int times){
        System.out.println("\n실행 결과");
        for (int i = 0; i < times; i++) {
            for (Car car : cars) {
                car.move();
            }
            System.out.println();
        }
    }
}
