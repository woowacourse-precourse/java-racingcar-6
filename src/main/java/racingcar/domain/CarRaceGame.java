package racingcar.domain;

import racingcar.controller.GameSimulator;
import racingcar.model.Race;
import racingcar.view.ResultsPrinter;
import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CarRaceGame {
    public CarRaceGame(){

        //입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = readLine();
        // 자동차 이름 파싱
        String[] carNames = inputNames.split(",");
        if (!isValidCarNames(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력하세요.");
        }

        System.out.println("시도할 회수는 몇 회인가요?");
        int tries = Integer.parseInt(readLine());

        //model
        Race race = new Race(carNames);
        //controller
        GameSimulator gameSimulator = new GameSimulator(race, tries);
        gameSimulator.runRace();
        //view
        ResultsPrinter resultsPrinter = new ResultsPrinter();
        resultsPrinter.printResults(race);
        resultsPrinter.printWinners(race.getWinners());

        //scanner.close();
    }
    private static boolean isValidCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }
}
