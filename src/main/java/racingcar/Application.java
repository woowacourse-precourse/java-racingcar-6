package racingcar;

import java.util.List;
import racingcar.domain.Player;
import racingcar.domain.RacingGame;

public class Application {
    static RacingGame racingGame;
    static Player player = new Player();
    static final View view = new View();

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame(){
        List<String> carNames = inputCarNames();
    }

    public static List<String> inputCarNames(){
        view.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        return player.inputCarNames();
    }

}
