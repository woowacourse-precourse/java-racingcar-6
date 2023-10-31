package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.OutputView;

public class RacingController {

    public static final int CONDITION_RANGE_MIN = 0;
    public static final int CONDITION_RANGE_MAX = 9;
    public static final int MOVE_LIMIT = 4;
    public static final String COMMA = ", ";
    private OutputView outputView = new OutputView();

    public String proceedRace(List<String> carNameList, Integer roundNumber) {
        printMessage();
        List<Car> cars = carSetting(carNameList);
        proceed(cars, roundNumber);
        return getWinner(cars);
    }

    private void printMessage() {
        outputView.printLine();
        outputView.printRaceResult();
    }

    private static List<Car> carSetting(List<String> carNameList) {
        List<Car> cars = new ArrayList<>();
        for (String car : carNameList) {
            cars.add(new Car(car, 0));
        }
        return cars;
    }

    private void proceed(List<Car> cars, Integer roundNumber) {
        for (int i = 0; i < roundNumber; i++) {
            for (Car car : cars) {
                move(car);
                outputView.printProgress(car);
            }
            outputView.printLine();
        }
    }

    private void move(Car car) {
        int condition = Randoms.pickNumberInRange(CONDITION_RANGE_MIN, CONDITION_RANGE_MAX);
        if (condition >= MOVE_LIMIT) {    //전진
            car.go();
        }
    }

    private String getWinner(List<Car> cars) {
        Collections.sort(cars, (o1, o2) -> Integer.compare(o2.getProgress(), o1.getProgress()));    //이동 횟수가 큰 순서대로 정렬

        StringBuilder sb = new StringBuilder();
        int maxScore = cars.get(0).getProgress();
        for (Car car : cars) {
            if (car.getProgress() == maxScore) {
                if (sb.length() > 0) {
                    sb.append(COMMA);
                }
                sb.append(car.getName());
            } else {
                break;
            }
        }

        return sb.toString();
    }
}
