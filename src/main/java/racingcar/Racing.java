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
        promptForExecutionCount();

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

    private void promptForExecutionCount() {
        String executionCount = ioHandler.readConsoleInputWithMessage("시도할 회수는 몇회인가요?");
        execution = new Execution(executionCount);
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
        ioHandler.printComment(name + " : " + "-".repeat(Math.max(0, count)));
    }

    private void printResult() {
        ArrayList<RacingCar> winnerList = getWinners();
        StringBuilder output = new StringBuilder();

        for (RacingCar racingCar : winnerList) {
            if (!output.toString().equals("")) {
                output.append(", ");
            }
            output.append(racingCar.name);
        }
        ioHandler.printComment("최종 우승자 : " + output);
    }

    private ArrayList<RacingCar> getWinners() {
        ArrayList<RacingCar> winnerList = new ArrayList<>();
        int maxCount = 0;

        Collections.sort(racingCars);
        for (int i = racingCars.size(); i > 0; i--) {
            if (racingCars.get(i - 1).count < maxCount) {
                break;
            }
            winnerList.add(racingCars.get(i - 1));
        }
        return winnerList;
    }
}
