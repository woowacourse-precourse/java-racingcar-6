package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Readline readline = new Readline();
        PlayGame playGame = new PlayGame();
        List<String> members = readline.Readinput();
        int TryNumber = readline.ReadTryNumber();
        playGame.TryGame(members,TryNumber);
    }
}
