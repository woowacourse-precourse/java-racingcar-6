package racingcar;
import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.*;


public class Application {

    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 자동차 이름을 입력받습니다.
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = readLine().split(",");
        System.out.println(String.join(",", carNames));
        // 자동차 이름을 검사합니다.
        for (String carName : carNames) {
            if (carName.length() < MIN_CAR_NAME_LENGTH || carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 1~5자 사이여야 합니다.");
            }
        }

        // 이동 횟수를 입력받습니다.
        System.out.println("시도할 회수는 몇회인가요?");
        int moveCount = Integer.parseInt(readLine());
        System.out.println(moveCount+"\n");

        // 자동차를 생성합니다.
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        System.out.print("실행 결과");
        // 자동차 경주를 시작합니다.
        for (int i = 0; i < moveCount; i++) {
            for (Car car : cars) {
                car.move();
            }

            // 이동 결과를 출력합니다.
            System.out.println();
            for (Car car : cars) {
                System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getPosition()));
            }

            // 우승자를 결정합니다.
            List<Car> winners = new ArrayList<>();
            for (Car car : cars) {
                if (car.getPosition() == cars.stream().mapToInt(Car::getPosition).max().getAsInt()) {
                    winners.add(car);
                }
            }

            // 우승자를 출력합니다.
            System.out.println("최종 우승자 : " + String.join(", ", (CharSequence) winners));

        }
    }
}
