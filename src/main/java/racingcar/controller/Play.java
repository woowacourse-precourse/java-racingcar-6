package racingcar.controller;

import java.util.HashMap;
import java.util.Map;

import static racingcar.view.Message.*;

public class Play {
    private Map<String, Integer> racerInformation = new HashMap<>();
    private int gameTryNumber;



    public void playGame(){
        System.out.println(START_MESSAGE);
        //게임정보저장기능
        inputGameInformation();
        //게임결과메세지생성기능
        playResultMessage();
        //최종승자메세지생성기능
        championMessage();
    }
}
