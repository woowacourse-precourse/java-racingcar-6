package racingcar;

import static constants.Constant.*;
import static constants.StringError.*;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class RacingManager {

    private static final RacingData racingData = new RacingData();
    private static final Map<String, Integer> playerResultMap = new HashMap<String, Integer>();

    public void run() {
        initSettingForPlaying();

        RacingController racingController = new RacingController(racingData);
        RacingView racingView = new RacingView(racingData);

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


        System.out.println(CMD_QUESTION_NAME);
        playersNameString = Console.readLine();

        playerNamesList = new ArrayList<String>(
                Arrays.asList(playersNameString.split(SEP_COMMA_STRING)));
        validatePlayerName(playerNamesList);


        System.out.println(CMD_QUESTION_NUMBER);
        tryNumber = Integer.parseInt(Console.readLine());

        racingData.saveRacingData(playerNamesList, tryNumber);
    }
    private void validatePlayerName(List<String> playerNamesList){
        for(String name: playerNamesList){
            int nameLength = name.length();
            if(nameLength>5)
                throw new IllegalArgumentException(wrongLengthError +
                        "\nExpect : maximum nameLength is 5" +
                        "\nInput : " +name + " Length : " + nameLength);
        }

    }
}
