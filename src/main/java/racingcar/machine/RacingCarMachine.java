package racingcar.machine;

import racingcar.machine.car.Car;
import racingcar.machine.car.CarInterface;
import racingcar.machine.ui.RacingCarMachineUI;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class RacingCarMachine implements RacingCarMachineInterface{
    private final RacingCarMachineUI ui;

    private final List<CarInterface> cars = new LinkedList<>();

    public RacingCarMachine(RacingCarMachineUI ui) {
        this.ui = ui;
    }

    @Override
    public void createCar() {
        ui.displayRequestCarNames();
        List<String> carNames = ui.inputCarNames();

        carNames.forEach(carName -> cars.add(new Car(carName)));
    }

    @Override
    public void attemptToMoveCars() {
        ui.displayRequestNumberOfAttempts();
        int tryAttemptNumber = ui.inputNumberOfAttempts();

        ui.displayRaceResult();
        for (int i = 0; i < tryAttemptNumber; i++) {
            cars.forEach(CarInterface::tryForwardMove);
            ui.displayRaceProgress(cars);
        }
    }

    @Override
    public void showWinner(){
        StringBuilder finalWinnerCarNames = new StringBuilder();
        int max = 0;
        for(CarInterface car : cars) {
            if(max < car.getDistance()) {
                max = car.getDistance();
                finalWinnerCarNames = new StringBuilder(car.getName());
            }
            else if (max == car.getDistance()) {
                finalWinnerCarNames.append(",");
                finalWinnerCarNames.append(car.getName());
            }
        }
        ui.displayFinalWinner(finalWinnerCarNames.toString());
    }
}
