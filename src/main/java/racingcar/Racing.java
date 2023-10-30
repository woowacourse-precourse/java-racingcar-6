package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Racing {
    IOHandler ioHandler = new IOHandler();
    List<RacingCar> racingCars = new ArrayList<>();
    Execution execution;

    public void run() {
        generateRacingCar();
        promptForExecutionCount();
        ioHandler.printComment("");
        ioHandler.printComment("실행결과");
    }


    private void generateRacingCar() {
        ioHandler.printComment("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = ioHandler.readConsoleInput();

        List<String> carsList = Arrays.asList(cars.split(","));
        for (String car : carsList) {
            racingCars.add(new RacingCar(car));
        }
    }

    private void promptForExecutionCount() {
        ioHandler.printComment("시도할 회수는 몇회인가요?");
        String executionCount = ioHandler.readConsoleInput();
        execution = new Execution(executionCount);
    }
}
