package racingcar;

import Model.Car;
import Model.CarList;
import Model.RaceCarNames;
import Model.TryCount;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    private static RaceCarNames raceCarNames;
    private static TryCount tryCount;
    private static CarList carList;

    public static void main(String[] args) {
        startRacingGame();
        printRaceWinners();
    }

    public static void startRacingGame() {
        receiveRaceCarNames();
        receiveTryCount();

        System.out.println("\n실행 결과");
        int gameCycle = tryCount.getTryCount();
        for (int i = 1; i <= gameCycle; i++) {
            carList.playGame();
            carList.printCarPositions();
        }
    }

    public static void receiveRaceCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String raceCarNamesInput = Console.readLine();
        raceCarNames = new RaceCarNames(raceCarNamesInput);
        carList = new CarList();

        List<String> carNameList = raceCarNames.parseCarNamesFromRaceCarInput();
        boolean carNamesValidFlag = true;
        for (String carName : carNameList) {
            Car car = new Car(carName);
            carNamesValidFlag &= car.isNameValid();
            carList.addCar(car);
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

    public static void printRaceWinners() {
        System.out.print("최종 우승자 : ");

        CarList raceWinners = carList.calculateRaceWinners();
        raceWinners.printCarNames();
    }




    /**
     * 테스트용 메서드
     */
    public static CarList getCarList() {
        return carList;
    }

    public static TryCount getTryCount() {
        return tryCount;
    }
}
