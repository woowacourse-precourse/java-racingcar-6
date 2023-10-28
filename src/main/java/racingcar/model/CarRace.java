package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class CarRace {
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 9;

    public void forwardOneTurn(Cars cars) {
        List<Car> raceCars = cars.getCars();
        raceCars.forEach(this::forwardRandomStep);
    }

    public void forwardRandomStep(Car car) {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
        if (randomNumber >= 4) {
            int currentStep = car.getForwardSteps();
            car.setForwardSteps(currentStep+1);
        }
    }

    public List<String> getRaceWinner(Cars cars) {
        List<Car> raceCars = cars.getCars();

        int winnerSteps = raceCars.stream()
                .mapToInt(Car::getForwardSteps)
                .max()
                .orElse(0);

        List<String> winnersName = raceCars.stream()
                .filter(car -> car.getForwardSteps()==winnerSteps)
                .map(Car::getCarName)
                .toList();
        return winnersName;
    }
}
