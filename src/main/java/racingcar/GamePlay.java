package racingcar;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.validation.RaceValidation;
import racingcar.view.RaceView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GamePlay {
    private List<Car> cars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();
    private int moveTrialCount;
    private int maxProgress = 0;
    private StringTokenizer st;
    private RaceValidation raceValidation = new RaceValidation();
    private RaceView raceView = new RaceView();

    public void start() {
        raceView.printExecutionResult();
        generateCar();
        raceView.printInputTrialCount();
        moveTrialCount = getMoveTrialCount();
        raceView.printExecutionResult();
        while (moveTrialCount-- > 0) {
            moveTrial();
            raceView.printProgress(cars);
        }
        calculateMaxProgress();
        findWinner();
        raceView.printFinalWinner(winners);
    }


    private void generateCar() {
        String input = Console.readLine();
        raceValidation.validationSeparator(input);
        st = new StringTokenizer(input, ",");
        while (st.hasMoreTokens()) {
            String carName = st.nextToken();
            raceValidation.validationNameLength(carName);
            cars.add(new Car(carName));
        }
    }

    private int getMoveTrialCount() {
        String input = Console.readLine();
        raceValidation.validationMoveTrailCount(input);
        return Integer.parseInt(input);
    }
    private void moveTrial() {
        for (Car car : cars) {
            moveForwardOrStop(car);
        }
    }

    private void moveForwardOrStop(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        System.out.println(car.getName() + "의 뽑은 값은" + randomNumber);
        if (randomNumber >= 4) {
            car.forward();
        }
    }
    private void calculateMaxProgress() {
        for (Car car : cars) {
            maxProgress = Math.max(maxProgress, car.getPosition());
        }
    }
    private void findWinner() {
        for (Car car : cars) {
            addWinner(car);
        }
    }

    private void addWinner(Car car) {
        if (car.getPosition() == maxProgress) {
            winners.add(car.getName());
        }
    }
}
