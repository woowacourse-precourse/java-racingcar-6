package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Constants;
import racingcar.domain.GameService;

public class Application {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        System.out.println(Constants.CAR_NAME_INPUT_MESSAGE);
        String input = Console.readLine();

        System.out.println(Constants.ATTEMP_INPUT_MESSAGE);

        String gameNum = Console.readLine();
        gameService.run(input, gameNum);
    }

}
