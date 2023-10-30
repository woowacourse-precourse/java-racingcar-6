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

    }

    private void saveRaceRound(String input) {
        Validate.isNumber(input);
        this.gameRound = Integer.parseInt(input);
    }

//    private void printResult() {
//        System.out.println("실행 결과");
//        List<String> names = service.getCarsName();
//        for (int i = 0; i < names.size(); i++) {
//            System.out.println(names.get(i) + " : ");
//        }
//    }

    private String repeatHyphen(int location) {
        return "-".repeat(Math.max(0, location));
    }



}
