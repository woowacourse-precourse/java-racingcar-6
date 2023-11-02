package racingcar;

import racingcar.User;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        Game game = new Game(user);
        game.gameStart();

    }
}
