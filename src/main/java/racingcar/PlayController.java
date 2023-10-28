package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayController {

    // 자동차 이름 부여
    public void generateRacingCarName(){
        //System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> players = new ArrayList<>();

        String inputPlayers = Console.readLine();

        String[] playersTemp = inputPlayers.split(",");

        players.addAll(Arrays.asList(playersTemp));
    }


}
