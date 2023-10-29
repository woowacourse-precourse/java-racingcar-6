package racingcar;

import Model.Car;
import Model.CarList;
import Model.RaceCarNames;
import Model.TryCount;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    private static CarList carList;

    public static void main(String[] args) {
        startRacingGame();
        printRaceWinners();
    }

    public static void startRacingGame() {
        receiveRaceCarNames();
        TryCount tryCount = receiveTryCount();
        int gameCycle = tryCount.changeToInteger();

        System.out.println("\n실행 결과");
        for (int i = 1; i <= gameCycle; i++) {
            carList.playGame();
            carList.printCarPositions();
        }
    }

    public static void receiveRaceCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String raceCarNamesInput = Console.readLine();
        RaceCarNames raceCarNames = new RaceCarNames(raceCarNamesInput);
        carList = new CarList();

        List<String> carNameList = raceCarNames.parseCarNamesFromRaceCarInput();
        for (String carName : carNameList) {
            Car car = new Car(carName);
            if (!car.isNameValid()) {
                throw new IllegalArgumentException();
            }
            carList.addCar(car);
        }
    }

    public static TryCount receiveTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCountInput = Console.readLine();
        TryCount tryCount = new TryCount(tryCountInput);

        if (!tryCount.isTryCountNumeric()) {
            throw new IllegalArgumentException();
        }
        return tryCount;
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
}
