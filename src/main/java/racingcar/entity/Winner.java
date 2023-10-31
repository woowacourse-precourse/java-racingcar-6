package racingcar.entity;

import racingcar.controller.GameController;
import racingcar.controller.MaxController;
import racingcar.generator.WinArrayGenerator;

import java.util.ArrayList;
import java.util.List;

import static racingcar.entity.Participantes.InputParticipantes;

public class Winner {
    public static int[] InputWinner(){
        int max=0;
        List<String> participantes=InputParticipantes();//참가자
        List<String> winner = new ArrayList<String>();//빔
        List<Integer> winner_index = new ArrayList<>();
        GameController gameController=new GameController();

        MaxController maxController=new MaxController();
        int[] forwinner = WinArrayGenerator.win;
        for(int i=0;i<forwinner.length;i++) {
            int cnt = forwinner[i];
            max = maxController.findMax(max, cnt);
        }
        for(int i=0;i<forwinner.length;i++){
            if(max == forwinner[i]){
                winner_index.add(i);
            }
        }
//        for(int i =0;i<winner_index.size();i++){
//            winner.add(participantes.get(i));
//        }
        return forwinner;
    }

}
