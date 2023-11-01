package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Execution;
import racingcar.domain.RacingCar;
import racingcar.io.IOHandler;

public class Racing {
    private final IOHandler ioHandler = new IOHandler();
    private final List<RacingCar> racingCars = new ArrayList<>();
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
        String input = ioHandler.readConsoleInputWithMessage("시도할 회수는 몇회인가요?");
        new Execution(input);
    }

    private void startRace() {
        racingService = new RacingService();
        ioHandler.printComment("\n" + "실행결과");

        racingService.startRace(Execution.count, racingCars);
    }

    private void printResult() {
        List<String> winners = racingService.getWinnerNames(racingCars);
        String output = String.join(", ", winners);
        ioHandler.printComment("최종 우승자 : " + output);
    }
}
