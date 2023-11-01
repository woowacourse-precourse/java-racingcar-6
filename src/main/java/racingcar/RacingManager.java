package racingcar;

import static constants.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;
import java.util.List;
import java.util.Arrays;

import java.util.Scanner;

public class RacingManager {

    private static final RacingData racingData = new RacingData();
    private static final RacingController racingController = new RacingController();
    private static final RacingView racingView = new RacingView();

    public void run() {
        initSettingForPlaying();

        do {
            Map<String, Integer> tempResultMap = racingController.play();
            racingView.render(tempResultMap);
        }
        while(!racingController.checkEnd());
        List<String> winnerString = racingController.getWinner();
        printWinnerString(winnerString);
    }

    private void printWinnerString(List<String>inputString){
        String result = String.join(SEP_PLAYER_STRING,inputString);
        System.out.println(CMD_WINNER_RESULT+result);
    }

    private void initSettingForPlaying() {
        String playersNameString;
        List<String> playerNamesList;
        Integer tryNumber;

        Scanner sc = new Scanner(System.in);

        System.out.println(CMD_QUESTION_NAME);
        playersNameString = Console.readLine();
//        playersNameString = sc.next();

        playerNamesList = new ArrayList<String>(
                Arrays.asList(playersNameString.split(SEP_PLAYER_STRING)));

//        for(String pl : playerNamesList){
//            System.out.println(pl);
//        }

        System.out.println(CMD_QUESTION_NUMBER);
        tryNumber = Integer.parseInt(Console.readLine());

//        tryNumber = Integer.parseInt(sc.next());
//        System.out.println(tryNumber);

        racingData.saveRacingData(playerNamesList, tryNumber);
    }

}
