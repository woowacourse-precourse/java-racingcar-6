package racingcar.view;

import static racingcar.utils.InputValidator.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;

/**
 * View는 입력과 출력과 관련된 로직만 있어야 한다.
 * 입력 값을 검증하는 것은 있어선 안된다. - 입력받은 자동차 이름을 저장하는 일급 컬렉션으로 생성 후 해당 클래스에서 검증로직 수행하도록 변경
 * Console.readLine() -> private 메서드로 추출하기
 */
public class RacingCarView {

    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = inputStringLine();
        String[] splitInputCars = cars.split(",");

        carNameValidate(splitInputCars);

        return splitInputCars;
    }

    public static int inputGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String count = inputStringLine();

        gameCountValidate(count);

        return Integer.parseInt(count);
    }

    public static void outputRaceResult(List<Car> cars) {
        for (Car car : cars) {
            String graphicOfDistance = DistanceFormat.DISTANCE_FORMAT.repeat(car.getDistance());
            System.out.println(car.getName() + " : " + graphicOfDistance);
        }
        System.out.println();
    }

    public static void outputWinners(List<Car> cars) {
        int maxOfDistance = cars.stream()
                .map(Car::getDistance)
                .mapToInt(car -> car)
                .max()
                .orElse(Integer.MIN_VALUE);

        List<String> winners = cars.stream()
                .filter(car -> car.getDistance() == maxOfDistance)
                .map(Car::getName)
                .toList();

        System.out.println("최종 우승자 : " + String.join(", ",winners));
    }

    private static String inputStringLine() {
        return Console.readLine();
    }
}
