package racingcar.View;

import racingcar.Controller.InputController;
import racingcar.Controller.RaceController;

import java.util.List;

public class RacingView {
    static RaceController raceController = new RaceController();
    static int raceTries;
    public static void UserInput() {

        InputController inputController = new InputController();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputController.getNameOfCar();
        System.out.println("시도할 회수는 몇회인가요?");
        raceTries = inputController.getRaceTries();
    }
    public static void GameResult(){
        System.out.println("실행 결과");
        for (int i = 0; i < raceTries; i++) {
            String PositionPrint=raceController.raceStart();
            System.out.println(PositionPrint);
        }
    }

    public static void GameWinner(){
        List<String> winners = raceController.getWinner();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}