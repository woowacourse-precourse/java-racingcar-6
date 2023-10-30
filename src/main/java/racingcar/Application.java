package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> racerList = RacerName.inputNames();
        Integer gameNum = GameStarter.gameNumber();

        InputNameCheck.nameCheck(racerList);
        GameSimulator.gameRunner(gameNum);
        System.out.println(racerList);

    }
}
