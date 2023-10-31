package racingcar.domain;

import racingcar.util.InputHandler;
import racingcar.util.Validator;

import java.util.List;

public class RacingGame {

    public static String CAR_NAMES_PROMPT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String NUMBER_OF_ATTEMPTS_PROMPT_MESSAGE = "시도할 회수는 몇회인가요?";

    private InputHandler inputHandler;
    private RacingCars racingCars;

    public RacingGame() {
        this.inputHandler = new InputHandler();
    }

    public void run(){
        setRacingCarsFromUser();

        System.out.println(NUMBER_OF_ATTEMPTS_PROMPT_MESSAGE);
        int numberOfAttempts = getNumberOfAttemptsFromUser();

        this.racingCars.attemptMove(numberOfAttempts);

    }

    private void setRacingCarsFromUser() {
        System.out.println(CAR_NAMES_PROMPT_MESSAGE);
        List<String> carNames = getCarNamesFromUser();
        this.racingCars = new RacingCars(carNames);
    }

    private List<String> getCarNamesFromUser() {
        String userInput = inputHandler.getUserInput();
        return Validator.validateCarNames(userInput);
    }

    private int getNumberOfAttemptsFromUser() {
        String userInput = inputHandler.getUserInput();
        return Validator.validateNumberOfAttempts(userInput);
    }


}
