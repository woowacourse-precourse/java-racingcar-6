package racingcar;


import racingcar.carlist.RacingCarList;
import racingcar.management.RacingGameManager;
import racingcar.user.User;
import racingcar.validation.Validator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        RacingCarList racingCarList = new RacingCarList(user);
        RacingGame racingGame = new RacingGame(user, racingCarList);
        racingGame.startGame();
    }
}
