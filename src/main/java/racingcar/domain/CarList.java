package racingcar.domain;

import static racingcar.view.RacingView.carMoveOrStopDecisionResultView;
import static racingcar.view.RacingView.newLine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.constant.CarConstant;
import racingcar.utill.NumberGenerator;

public class CarList {
    private final List<Car> carList;
    private final NumberGenerator numberGenerator;

    public CarList(List<Car> carList, NumberGenerator numberGenerator) {
        this.carList = new ArrayList<>(carList);
        this.numberGenerator = numberGenerator;
    }

    public void racing(int attemptNumber) {
        for (int i = 0; i < attemptNumber; i++) {
            carsStopOrMoveDecisionCall();
        }
    }

    private void carsStopOrMoveDecisionCall() {
        for (Car car : carList) {
            int carPosition = car.stopOrMoveDecision(numberGenerator.generateNumber());
            String carName = car.getCarName();
            carMoveOrStopDecisionResultView(carName, carPosition);
        }

        newLine();
    }

    public String racingWinnerDecision() {
        return String.join(", ", findWinner());
    }

    private List<String> findWinner() {
        return carList.stream()
                .filter(car -> car.isSamePosition(findMaxPosition()))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getCarPosition)
                .max().orElse(CarConstant.CAR_INIT_POSITION);
    }

    @Override
    public String toString() {
        return carList.toString();
    }
}
