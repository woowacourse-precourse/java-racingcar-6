package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.*;

import java.util.List;

public class Application {
    private static final UserInput userInput = new UserInput();
    private static final ContainerSetting containerSetting = new ContainerSetting(new RandomNumberGenerator(Constants.MIN_RANDOM_NUM, Constants.MAX_RANDOM_NUM));
    private static final SystemOutput systemOutput = new SystemOutput();
    private static final GameService gameService = new GameService(userInput, containerSetting, systemOutput);

    public static void main(String[] args) {
        System.out.println(Constants.CAR_NAME_INPUT_MESSAGE);
        String input = Console.readLine();

        System.out.println(Constants.ATTEMP_INPUT_MESSAGE);
        String gameNum = Console.readLine();

        gameService.run(input, gameNum);
    }
}

