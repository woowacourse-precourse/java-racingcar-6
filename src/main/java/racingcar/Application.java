package racingcar;

import Model.Car;
import Model.RaceCarNames;
import Model.TryCount;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static RaceCarNames raceCarNames;
    private static TryCount tryCount;
    private static List<Car> carList;

    public static void main(String[] args) {
        startRacingGame();
        printRaceWinners();
    }

    public static void startRacingGame() {
        receiveRaceCarNames();
        receiveTryCount();

        int gameCycle = tryCount.getTryCount();
        for (int i = 1; i <= gameCycle; i++) {
            playGame();
            printCurrentRacingResult();
        }

        calculateWhoAreTheWinners();
    }

    public static void playGame() {
        for (Car car : carList) {
            int randomNumber = generateRandomNumber();
            if (randomNumber >= 4) {
                car.moveForward();
            } else if (randomNumber < 4) {
                //
            }
        }
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void receiveRaceCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String raceCarNamesInput = Console.readLine();
        raceCarNames = new RaceCarNames(raceCarNamesInput);
        carList = new ArrayList<>();

        List<String> carNameList = raceCarNames.parseCarNamesFromRaceCarInput();
        boolean carNamesValidFlag = true;
        for (String carName : carNameList) {
            Car car = new Car(carName);
            carNamesValidFlag &= car.isNameValid();
            carList.add(car);
        }

        if (!carNamesValidFlag) {
            throw new IllegalArgumentException();
        }
    }

    public static void receiveTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCountInput = Console.readLine();
        tryCount = new TryCount(tryCountInput);

        if (!tryCount.isTryCountNumeric()) {
            throw new IllegalArgumentException();
        }
    }

    public static void calculateWhoAreTheWinners() {
        //
    }

    public static void printCurrentRacingResult() {
        System.out.println("실행 결과");
    }

    public static void printRaceWinners() {
        System.out.println("최종 우승자 : ");
    }

    // test용 코드
    public static RaceCarNames getRaceCarNames() {
        return raceCarNames;
    }

    public static TryCount getTryCount() {
        return tryCount;
    }
}
