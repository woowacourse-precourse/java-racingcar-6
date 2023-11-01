package racingcar;

import static constants.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RacingManager {

    private static final RacingData racingData = new RacingData();
    private static final Map<String, Integer> playerResultMap = new HashMap<String, Integer>();

    public void run() {
        initSettingForPlaying();

        RacingController racingController = new RacingController(racingData);
        RacingView racingView = new RacingView();

        racingController.initSetting(playerResultMap);
        System.out.println(CMD_PLAY_RESULT);

        do {
           racingController.play(playerResultMap);
           racingView.render(playerResultMap);
        }
        while(!racingController.checkEnd(playerResultMap));

        List<String> winnerString = racingController.getWinnerList();
        printWinnerString(winnerString);
    }

    private void printWinnerString(List<String>inputString){
        String result = String.join(SEP_COMMA_ONESPACE_STRING,inputString);
        System.out.println(CMD_WINNER_RESULT+result);
    }

    private void initSettingForPlaying() {
        String playersNameString;
        List<String> playerNamesList;
        Integer tryNumber;

        Scanner sc = new Scanner(System.in);

        System.out.println(CMD_QUESTION_NAME);
//        playersNameString = Console.readLine();
        playersNameString = sc.next();

        playerNamesList = new ArrayList<String>(
                Arrays.asList(playersNameString.split(SEP_COMMA_STRING)));

        for(String pl : playerNamesList){
            System.out.println(pl);
        }

        System.out.println(CMD_QUESTION_NUMBER);
//        tryNumber = Integer.parseInt(Console.readLine());

        tryNumber = Integer.parseInt(sc.next());
        System.out.println(tryNumber);

        racingData.saveRacingData(playerNamesList, tryNumber);
    }

}
