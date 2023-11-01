package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Racing {
    List<RacingCar> racingCars = new ArrayList<>();
    IOHandler ioHandler = new IOHandler();

    public void run() {
        ioHandler.printComment("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        generateRacingCar();
    }


    private void generateRacingCar() {
        String cars = ioHandler.readConsoleInput();
        List<String> carsList = Arrays.asList(cars.split(","));
        for (String car : carsList) {
            racingCars.add(new RacingCar(car));
        }
    }
}
