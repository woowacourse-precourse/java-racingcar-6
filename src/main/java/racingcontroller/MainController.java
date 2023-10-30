package racingcontroller;

import java.util.LinkedHashMap;
import racingmodel.CarRacingGame;
import racingview.MainView;
import racingview.Viewable;
import validation.ValidationMan;

public class MainController {
    private Viewable view = null;
    private CarRacingGame model = null;

    public MainController() {
        this.view = new MainView(); // composite
    }

    public void turnOn() {
        view.speakStart();
        leadGame();
    }

    private void leadGame() throws IllegalArgumentException {
        initializeCarRacingGame();
        view.askForTimes();

        String times = InputReader.inputTimes();
        if(!ValidationMan.checkException(times))
        {
            throw new IllegalArgumentException();
        }

        view.speakResultStart();
        for (int i = 0; i < Integer.parseInt(times); i++) {
            model.changeStatus();
            view.speakResult(model.getCarName());
        }
        view.speakWinner(model.getWinner());
    }

    private void initializeCarRacingGame()
    {
        String[] userInput = CarMapGenerator.cutName(InputReader.inputCarName());
        LinkedHashMap<String, StringBuilder> carName = CarMapGenerator.makeLinkedHashMap(userInput);
        if (!ValidationMan.checkException(carName, userInput.length)) {
            throw new IllegalArgumentException();
        }
        model = new CarRacingGame(carName);
    }
}
