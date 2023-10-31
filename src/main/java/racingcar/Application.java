package racingcar;

import basis.Converter;
import basis.MovingStatus;
import basis.Race;
import basis.WinnerResult;
import io.UserInput;
import validation.UserInputValidator;

public class Application {
    public static void main(String[] args) {
        UserInputValidator userInputValidator = new UserInputValidator();
        Converter converter = new Converter(userInputValidator);
        UserInput ui = new UserInput(converter);
        MovingStatus movingStatus = new MovingStatus();
        WinnerResult winnerResult = new WinnerResult(ui);
        Race race = new Race(movingStatus, winnerResult, ui);
        race.run();
    }
}