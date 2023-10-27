package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.validator.RaceValidator;
import racingcar.view.RaceView;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Race {

    private List<Car> cars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();
    private int moveTrialCount;
    private int maxProgress = 0;
    private StringTokenizer st;
    private RaceValidator raceValidator = new RaceValidator();
    private RaceView raceView = new RaceView();

    public void start() {
        raceView.printInputCarname();
        generateCar();

        raceView.printInputMoveTrialCount();
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
        st = new StringTokenizer(input, ",");
        raceValidator.validateSeparator(input);
        while (st.hasMoreTokens()) {
            String carname = st.nextToken();
            raceValidator.validateCarname(carname);
            cars.add(new Car(carname));
        }
    }

    private int getMoveTrialCount() {
        String input = Console.readLine();
        raceValidator.validateMoveTrialCount(input);
        return Integer.parseInt(input);
    }

    private void moveTrial() {
        for (Car car : cars) {
            moveForwardOrStop(car);
        }
    }

    private void moveForwardOrStop(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        System.out.println(car.getName() + "의 랜덤값 : " + randomNumber);
        if (randomNumber >= 4) {
            car.forward();
        }
    }

    private void calculateMaxProgress() {
        for (Car car : cars) {
            maxProgress = Math.max(maxProgress, car.getProgress());
        }
    }

    private void findWinner() {
        for (Car car : cars) {
            addWinner(car);
        }
    }

    private void addWinner(Car car) {
        if (car.getProgress() == maxProgress) {
            winners.add(car.getName());
        }
    }
}
