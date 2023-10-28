package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class RaceViewer {
    private final static String INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_STEP_NUMBER = "시도할 회수는 몇회인가요?";

    public void showCarsNameInput() {
        System.out.println(INPUT_CARS_NAME);
    }

    public void showStepNumberInput() {
        System.out.println(INPUT_STEP_NUMBER);
    }


    public void showCarsStep(Cars cars) {
        List<Car> carsStep = cars.getCars();
        carsStep.forEach(this::showCarStep);
    }

    public void showCarStep(Car car) {
        StringBuilder carStep = new StringBuilder();
        carStep.append(car.getCarName() + " : ");
        for (int i=0;i<car.getForwardSteps();i++) {
            carStep.append('-');
        }
        System.out.println(carStep);
    }


    public void showRaceWinner(List<String> winners) {
        StringBuilder raceWinners = new StringBuilder();
    }
}
