package racingcontroller;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;
import racingmodel.MainModel;
import racingview.MainView;
import racingview.Viewable;
import validation.ValidationMan;

public class MainController {
    private Viewable view = null;
    private MainModel model = null;

    public MainController() {
        this.view = new MainView(); // composite
        this.model = new MainModel();
    }

    public void turnOn() {
        view.speakStart();
        leadGame();
    }

    private void leadGame() throws IllegalArgumentException {
        ValidationCallMan.callexExceptionCheckForCar(model);
        view.askForTimes();
        String times = InputMan.inputTimes();
        ValidationCallMan.callExceptionCheckForTimes(model, times);
        view.speakResultStart();
        ;

        for (int i = 0; i < Integer.parseInt(times); i++) {
            model.changeStatus();
            view.speakResult(model.getCarName());
        }
        view.speakWinner(model.getWinner());
    }
}
