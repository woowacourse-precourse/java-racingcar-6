package racingcontroller;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;
import racingmodel.MainModel;
import racingview.MainView;
import racingview.Viewable;

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

    private void leadGame() throws IllegalArgumentException
    {
        if(!model.saveName(InputMan.inputCarName()))
        {
            throw new IllegalArgumentException();
        }
        view.askForTimes();

        String times = InputMan.inputTimes();

        if(!model.exceptionCheck(times))
        {
            throw new IllegalArgumentException();
        }

        view.speakResultStart();;

        for(int i = 0; i < Integer.parseInt(times); i++)
        {
            model.changeStatus();
            view.speakResult(model.getCarName());
        }
        view.speakWinner(model.getWinner());
    }
}
