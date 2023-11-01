package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_TITLE_MESSAGE = "\n" + "실행 결과";
    private static final String FINAL_WINNERS_MESSAGE = "최종 우승자 : ";


    private static List<Car> cars = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String carNameInput = camp.nextstep.edu.missionutils.Console.readLine();

        List<String> carNames = Arrays.stream(carNameInput.split(",")).toList();
        for (String carName : carNames) {
            validateCarName(carName);
            Car car = new Car(carName);
            cars.add(car);
        }

        System.out.println(TRY_COUNT_INPUT_MESSAGE);
        String tryCountInput = camp.nextstep.edu.missionutils.Console.readLine();
        int tryCount = Integer.parseInt(tryCountInput);

        System.out.println(RESULT_TITLE_MESSAGE);
        for (int nowCount = 1; nowCount <= tryCount; nowCount++) {
            processGame();
            printResultOfTry();
        }

        printGameResult();
    }

    static void processGame() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

    static void printResultOfTry() {
        for (Car car : cars) {
            String movingCount = "-".repeat(car.getPosition());
            System.out.println(car.getName() + " : " + movingCount);
        }
        System.out.println();
    }

    static List<String> getWinners() {
        int maxMove = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() < maxMove) {
                continue;
            }
            if (car.getPosition() > maxMove) {
                winners = new ArrayList<>();
                maxMove = car.getPosition();
            }

            winners.add(car.getName());
        }
        return winners;
    }

    static void printGameResult() {
        List<String> winners = getWinners();
        System.out.print(FINAL_WINNERS_MESSAGE);
        System.out.println(String.join(", ", winners));
    }

    static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
