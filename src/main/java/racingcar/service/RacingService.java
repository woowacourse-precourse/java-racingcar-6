package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.validator.CarValidator.checkAllCarNameException;
import static racingcar.validator.TryCountValidator.checkAllTryCountException;
import static racingcar.view.InputView.noticeForGetCarNameNotification;
import static racingcar.view.InputView.noticeForGetNumberOfTry;
import static racingcar.view.OutputView.printResult;
import static racingcar.view.OutputView.printWinnerList;

public class RacingService {

    private static final String DELIMITER = ",";
    private static final int MINIMUM_MOVE_CONDITION = 4;

    public static void doRacing(){
        List<Car> carList = new ArrayList<>();
        getCarInput(carList);
        int tryCount = getTryCount();
        for (int i = 0; i < tryCount; ++i) {
            moveOrNot(carList);
            printResult(carList);
        }
        printWinnerList(carList);
    }

    public static int getTryCount() {
        noticeForGetNumberOfTry();
        String tryCount = readLine();
        checkAllTryCountException(tryCount);
        return Integer.parseInt(tryCount);
    }

    public static void getCarInput(List<Car> carList){
        String carName = getCarName();
        splitCarList(carList, carName);
        checkAllCarNameException(carList);
    }

    public static String getCarName() {
        noticeForGetCarNameNotification();
        return readLine();
    }

    public static void splitCarList(List<Car> carList, String carNames) {
        String[] carNameList = carNames.split(DELIMITER);
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }

    public static void moveOrNot(List<Car> carList) {
        for (Car car : carList) {
            determineRandomNumber(car);
        }
    }

    public static void determineRandomNumber(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= MINIMUM_MOVE_CONDITION) {
            car.move();
        }
    }
}
