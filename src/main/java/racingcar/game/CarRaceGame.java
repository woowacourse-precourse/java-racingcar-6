package racingcar.game;

import java.util.List;
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
        System.out.println();

    }

    private void saveRaceRound(String input) {
        Validate.isNumber(input);
        this.gameRound = Integer.parseInt(input);
    }

    private void printResult() {
        System.out.println("실행 결과");
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
