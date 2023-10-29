package racingcar;

import java.util.List;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Reader reader = new Reader();
        Game game = new Game();
        List<String> members = reader.InputReader();
        int TryNumber = reader.NumberReader();
        game.TryGame(members,TryNumber);
    }
}
