package racingcar.entity;

import racingcar.controller.GameController;
import racingcar.controller.MaxController;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public static List<String> winner(){
        int max=0;
        List<String> winner = new ArrayList<>();
        GameController gameController=new GameController();
        int[] forwinner = gameController.win;
        for(int i=0;i<forwinner.length;i++) {
            int cnt = forwinner[i];
            max = MaxController(max, cnt);
        }


        return winner;
    }

}
