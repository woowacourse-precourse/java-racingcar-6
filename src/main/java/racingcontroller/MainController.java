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

    private void leadGame() {
        initializeCarRacingGame(CarMapGenerator.cutName(InputReader.inputCarName()));
        view.askForTimes();
        String times = getUserInput();

        view.speakResultStart();
        processWithResults(times);
        view.speakWinner(model.getWinner());
    }

    private void initializeCarRacingGame(String[] userInput) throws IllegalArgumentException {
        LinkedHashMap<String, StringBuilder> carName = CarMapGenerator.makeLinkedHashMap(userInput);
        if (!ValidationMan.checkException(carName, userInput.length)) {
            throw new IllegalArgumentException();
        }
        model = new CarRacingGame(carName);
    }

    private String getUserInput() throws IllegalArgumentException{
        String times = InputReader.inputTimes();
        if (!ValidationMan.checkException(times)) {
            throw new IllegalArgumentException();
        }
        return times;
    }

    private void processWithResults(String times) {
        for (int i = 0; i < Integer.parseInt(times); i++) {
            model.changeGame();
            view.speakResult(model.getCarName());
        }
    }
}
