package controller;


import static constant.ConstantNumber.DEFAULT_MAX_COUNT;
import static constant.ConstantNumber.MAX_NUMBER_RANGE;
import static constant.ConstantNumber.MIN_NUMBER_RANGE;
import static constant.ConstantString.EXECUTION_RESULT;


import camp.nextstep.edu.missionutils.Randoms;
import domain.Car;
import domain.Cars;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class RaceController {
    private Cars cars;

    public void set() {
        cars = new Cars(InputView.carNames());
        start(InputView.attemptCount());
    }

    private void start(int attemptCount) {
        System.out.println(EXECUTION_RESULT);
        race(attemptCount);
        OutputView.printWinners(findWinners());
    }

    private void race(int attemptCount) {
        for (int i = attemptCount; i > 0; i--) {
            decideForwardMovement();
            OutputView.printProcess(cars.getCarsList());
        }
    }

    private void decideForwardMovement() {
        cars.getCarsList()
                .forEach(car -> {
                    car.moveOrStop(getRandomNumber());
                });
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER_RANGE.getValue(), MAX_NUMBER_RANGE.getValue());
    }

    private List<String> findWinners() {
        List<String> winnerList = new ArrayList<>();
        int maxCount = DEFAULT_MAX_COUNT.getValue();

        for (Car car : cars.getCarsList()) {
            int count = car.getCount();
            if (count > maxCount) {
                maxCount = count;
                winnerList.clear();
                winnerList.add(car.getCarName());
            } else if (count == maxCount) {
                winnerList.add(car.getCarName());
            }
        }
        return winnerList;
    }
}
