package racingcar.view;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    public void gameProgress(HashMap<String, String> hs, List<String> carPlayers) {
        for (String key : carPlayers) {
            System.out.println(key + " : " + hs.get(key));
        }
        System.out.println("");
    }
}
