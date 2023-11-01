package racingcar;

import racingcar.Controller.RacingGameController;
import racingcar.Model.RandomNumberGenerator;
import racingcar.Model.RandomNumberGenertorImpI;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.View.RacingGameView;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ");
        String carNamesInput = Console.readLine();
        List<String> carNames = Arrays.asList(carNamesInput.split(","));
        System.out.println("시도할 회수는 몇회인가요? ");
        String gameInput = Console.readLine();
        int game = Integer.parseInt(gameInput);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenertorImpI();
        RacingGameView view = new RacingGameView();
        RacingGameController controller = new RacingGameController(carNames, view, randomNumberGenerator);

        System.out.println("실행 결과");
        controller.startGame(game);
    }
}
