package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.StringJoiner;
import racingcar.domain.Car;
import racingcar.domain.CarGroup;
import racingcar.validator.InputValidator;

public class Application {
    public static void main(String[] args) {
        CarGroup carGroup = new CarGroup();
        inputCars(carGroup);

        int tryCount = inputCount();
        printRoundStatus(tryCount, carGroup);

        int winnerPosition = carGroup.getMaximumPosition();
        StringJoiner winnerList = getWinners(carGroup, winnerPosition);
        printWinners(winnerList);
    }

    private static void printWinners(StringJoiner winnerList) {
        System.out.println("최종 우승자 : " + winnerList);
    }

    private static StringJoiner getWinners(CarGroup carGroup, int winnerPosition) {
        StringJoiner winnerList = new StringJoiner(",");

        for (Car car : carGroup.getCars()) {
            if (car.getPosition() == winnerPosition) {
                String carNickname = car.getNickname();
                winnerList.add(carNickname);
            }
        }
        return winnerList;
    }


    private static void printRoundStatus(int tryCount, CarGroup carGroup) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            movingCars(carGroup);
            printProgress(carGroup);
        }
    }

    private static void printProgress(CarGroup carGroup) {
        for (Car car : carGroup.getCars()) {
            String carNickname = car.getNickname();
            int carPosition = car.getPosition();
            String progress = "-".repeat(carPosition);
            System.out.println(carNickname + " : " + progress);
        }
        System.out.println();
    }

    private static void movingCars(CarGroup carGroup) {
        for (Car car : carGroup.getCars()) {
            int movingWeight = Randoms.pickNumberInRange(0, 9);
            if (movingWeight >= 4) {
                car.moving();
            }
        }
    }

    private static int inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readLine();
        new InputValidator().validateTryCount(input);
        return Integer.parseInt(input);
    }

    private static void inputCars(CarGroup carGroup) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = readLine();
        for (String carName : cars.split(",")) {
            Car car = new Car(carName);
            carGroup.addCar(car);
        }
    }
}
