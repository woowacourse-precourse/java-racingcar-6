package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.constant.CarRaceMessage;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.CarRaceService;
import racingcar.validate.Validate;

public class CarRaceGame implements Game {
    private CarRaceService service;
    private int gameRound;

    public CarRaceGame() {
        this.service = new CarRaceService();
        this.gameRound = 0;
    }

    @Override
    public void startGame() {
        System.out.println(CarRaceMessage.PROMPT_NAME.getMessage());
        String input = Console.readLine();
        service.addCars(input);
        System.out.println(CarRaceMessage.PROMPT_COUNT.getMessage());
        input = Console.readLine();
        saveRaceRound(input);
        System.out.println("\n실행 결과");
        for (int i = 0; i < this.gameRound; i++) {
            service.moveCars();
            printResult();
            System.out.println();
        }
        printFinalResult();
    }

    private void saveRaceRound(String input) {
        Validate.isNumber(input);
        this.gameRound = Integer.parseInt(input);
    }

    private void printResult() {
        List<String> names = service.getCarsName();
        List<Integer> locations = service.getCarsLocation();
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " : " + repeatHyphen(locations.get(i)));
        }
    }

    private String repeatHyphen(int location) {
        return "-".repeat(Math.max(0, location));
    }

    private void printFinalResult() {
        List<String> names = service.getWinnersName();
        StringBuilder sb = new StringBuilder("최종 우승자 : ");
        for (String name : names) {
            sb.append(name).append(", ");
        }
        sb.substring(0, sb.length() - 2);
        System.out.println(sb);
    }


}
