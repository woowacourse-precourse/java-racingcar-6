package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> racerList = RacerName.inputNames();
        String gameNum = GameStarter.gameNumber();

        InputNameCheck.nameCheck(racerList);
        Integer successfulGameNum = InputNumCheck.numCheck(gameNum);
        GameSimulator.gameRunner(successfulGameNum);
        System.out.println(racerList);

    }
}
