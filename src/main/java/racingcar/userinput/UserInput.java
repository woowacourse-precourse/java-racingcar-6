package racingcar.userinput;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Race;

public class UserInput {

    private static final String CAR_NAME_INPUT_DELIMITER = ",";
    private static final String ASK_GAME_COUNT = "시도할 회수는 몇회인가요?";

    private final Race race;
    private final UserInputValidator inputValidator;

    public UserInput(Race race) {
        this.race = race;
        this.inputValidator = new UserInputValidator(race);
    }

    public void inputCarNames() {
        String userInput = Console.readLine();
        String[] carNames = userInput.split(CAR_NAME_INPUT_DELIMITER);
        for (String carName : carNames) {
            inputValidator.carName(carName);
            race.createCar(carName);
        }
    }

    public void inputGameCount() {
        System.out.println(ASK_GAME_COUNT);
        String userInput = Console.readLine();
        inputValidator.gameCount(userInput);
        race.saveGameCount(userInput);
    }
}
