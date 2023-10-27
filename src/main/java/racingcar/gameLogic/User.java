package racingcar.gameLogic;

import java.util.List;
import racingcar.utils.StringChanger;
import racingcar.views.InputViewer;

public class User {
    public List<String> inputCarName(){
        String userInput = InputViewer.requestCarNameInput();
        String[] splitStrings = StringChanger.stringToTrimStringArray(userInput);
        List<String> carNameList = StringChanger.stringArrayToStringList(splitStrings);
        return carNameList;
    }
}
