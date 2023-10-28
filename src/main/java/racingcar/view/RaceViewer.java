package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class RaceViewer {
    private final static String INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_STEP_NUMBER = "시도할 회수는 몇회인가요?";
    private final static String RUN_RESULT = "\n실행 결과";

    public void showCarsNameInput() {
        System.out.println(INPUT_CARS_NAME);
    }

    public void showRepeatNumberInput() {
        System.out.println(INPUT_STEP_NUMBER);
    }


    public void showResultString() {
        System.out.println(RUN_RESULT);
    }

    public void showCarsStep(Cars cars) {
        List<Car> carsStep = cars.getCars();
        carsStep.forEach(this::showCarStep);
        System.out.println();
    }

    public void showCarStep(Car car) {
        StringBuilder carStep = new StringBuilder();

        carStep.append(car.getCarName()).append(" : ");
        int steps = car.getForwardSteps();
        carStep.append("-".repeat(steps));

        System.out.println(carStep);
    }


    public void showRaceWinner(List<String> winners) {
        StringBuilder raceWinners = new StringBuilder("최종 우승자 : ");
        winners.forEach(winner -> raceWinners.append(winner).append(", "));
        raceWinners.setLength(raceWinners.length() - 2);

        System.out.println(raceWinners);
    }
}
