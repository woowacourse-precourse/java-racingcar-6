package racingcar.service;

import java.util.ArrayList;
import java.util.HashMap;
import racingcar.util.GameUtil;
import racingcar.util.ReturnUtil;

public class StageService {

    public boolean stageProcess() {
        int random = GameUtil.createRandomNumber();
        if (GameUtil.moveOrStop(random)) {
            return true;
        }
        return false;
    }

    public ArrayList<String> checkStageResult(HashMap<String, Integer> cars) {
        ArrayList<String> list = new ArrayList<>();
        for (String key : cars.keySet()) {
            String status = ReturnUtil.statusFormat(cars.get(key));
            String result = ReturnUtil.stageResultFormat(key, status);
            list.add(result);
        }
        return list;
    }
}
