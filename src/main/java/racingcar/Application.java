package racingcar;

import base.Converter;
import base.MovingStatus;
import base.Race;
import base.WinnerResult;
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