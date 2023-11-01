package racingcar;
import camp.nextstep.edu.missionutils.*;
import controller.InputValidator;
import model.Player;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static controller.InputValidator.numberHandlingException;

public class Application {

    static CarRaceGame carRaceGame = new CarRaceGame();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        run();
    }

    public static void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String userInputName = readLine();
        String[] userNames = saveName(userInputName);
        Player[] players = makePlayers(userNames, userNames.length);
        System.out.println("시도할 횟수는 몇회인가요?");
        String number = readLine();
        carRaceGame.run(number, players);
    }
    public static String[] saveName(String userInputName) {
        String[] userNames = InputValidator.exceptionHanding(userInputName);
        return userNames;
    }

    public static Player[] makePlayers(String[] userNames, int names) {
        Player[] players = new Player[names];
        for(int i = 0; i < names; i++) {
            players[i] = new Player(userNames[i]);
        }
        return players;
    }
}


