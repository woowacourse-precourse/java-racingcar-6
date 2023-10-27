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
    private StringTokenizer st;
    private RaceValidator raceValidator = new RaceValidator();
    private int moveTrialCount;
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
}
