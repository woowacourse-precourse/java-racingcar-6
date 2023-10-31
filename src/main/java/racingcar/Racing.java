package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {
    IOHandler ioHandler = new IOHandler();
    List<RacingCar> racingCars = new ArrayList<>();
    Execution execution;

    public void run() {
        generateRacingCar();
        generateExecutionCount();

        ioHandler.printComment("\n" + "실행결과");

        execute();
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
        execution = new Execution();
    }

    private void execute() {
        int count = Execution.count;
        for (int i = 0; i < count; i++) {
            for (RacingCar racingCar : racingCars) {
                racingCar.execute();
                printStatus(racingCar.name, racingCar.count);
            }
            ioHandler.printComment("");
        }
    }

    private void printStatus(String name, int count) {
        ioHandler.printComment(name + " : " + "-".repeat(count));
    }

    private void printResult() {
        String output = String.join(", ", getWinners());
        ioHandler.printComment("최종 우승자 : " + output);
    }

    private ArrayList<String> getWinners() {
        ArrayList<String> winnerList = new ArrayList<>();

        Collections.sort(racingCars);
        int maxCount = racingCars.get(racingCars.size() - 1).count;
        for (int i = racingCars.size(); i > 0; i--) {
            RacingCar racingCar = racingCars.get(i - 1);
            if (racingCar.count < maxCount) {
                break;
            }
            winnerList.add(racingCar.name);
        }
        return winnerList;
    }
}
