package racingcar.view;

import racingcar.model.Car;
import racingcar.model.CarRepository;

import java.util.List;

import static racingcar.constant.Constants.*;

public class OutputView {


    public void printOneRoundResult(CarRepository carRepository) {
        for (Car car : carRepository.getCars()) {
            System.out.printf(OUTPUT_CAR_SCORE, car.getName(), OUTPUT_SCORE_STRING.repeat(car.getForwardCount()));
        }
        System.out.println();
    }

    public void getResult(List<String> maxCars) {
        System.out.printf(OUTPUT_FINAL_WINNER, maxCars.get(0));
        for (int i = 1; i < maxCars.size(); i++) {
            System.out.print(OUTPUT_FINAL_WINNER_SPLITTER + maxCars.get(i));
        }
        System.out.println();
    }
}
