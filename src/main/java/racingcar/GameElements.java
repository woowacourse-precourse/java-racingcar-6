package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameElements {
    private List<String> carNameList = new ArrayList<>();
    private int tryCount = 0;

    public void carNamesSetting(List<String> carNameListByUser) {
        carNameList = carNameListByUser;
    }

    public void tryCountSetting(int tryCountByUser) {
        tryCount = tryCountByUser;
    }
}
