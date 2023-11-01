package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private IOHandler ioHandler = new IOHandler();
    private List<RacingCar> racingCars = new ArrayList<>();
    private RacingService racingService;

    public void run() {
        generateRacingCar();
        generateExecutionCount();

        startRace();
        printResult();
    }

    private void generateRacingCar() {
        String cars = ioHandler.readConsoleInputWithMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String[] carsList = cars.split(",");
        for (String car : carsList) {
            racingCars.add(new RacingCar(car));
        }
    }

    private void generateExecutionCount() {
        new Execution();
    }

    private void startRace() {
        racingService = new RacingService(racingCars, Execution.count);
        ioHandler.printComment("\n" + "실행결과");

        racingService.startRace();
    }

    private void printResult() {
        List<String> winners = racingService.getWinnerNames();
        String output = String.join(", ", winners);
        ioHandler.printComment("최종 우승자 : " + output);
    }
}
