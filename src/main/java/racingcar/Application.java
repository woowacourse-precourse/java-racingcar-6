package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.PlayRacingGame;
import racingcar.service.PrintResult;
import racingcar.service.UserInput;
import racingcar.service.UserInputValidate;

public class Application {
    private final UserInput userInput;
    private final UserInputValidate userInputValidate;
    private final PlayRacingGame playRacingGame;
    private final PrintResult printResult;

    public Application(UserInput userInput, UserInputValidate userInputValidate, PlayRacingGame playRacingGame,
                       PrintResult printResult) {
        this.userInput = userInput;
        this.userInputValidate = userInputValidate;
        this.playRacingGame = playRacingGame;
        this.printResult = printResult;
    }

    public static void main(String[] args) {
        UserInput input = new UserInput();
        UserInputValidate inputValidate = new UserInputValidate();
        PlayRacingGame playGame = new PlayRacingGame();
        PrintResult printResult = new PrintResult();

        Application app = new Application(input, inputValidate, playGame, printResult);

        app.run();
    }

    private void run() {
        // init
        String[] names = userInput.inputCarName();
        //valid
        List<Car> cars = userInputValidate.validate(names);
        // 이동 횟수 묻기
        int moveCount = userInput.tryCount();
        //play racing game
        playRacingGame.play(moveCount, cars);
        //최종 결과
        printResult.printWinner(cars);
    }
}
