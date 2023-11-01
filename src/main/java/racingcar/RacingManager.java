package racingcar;

import static constants.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingManager {

    private static final RacingData racingData = new RacingData();


    public void play() {
        initSettingForPlaying();

    }

    private void initSettingForPlaying() {
        String playersNameString;
        List<String> playerNamesList;
        Integer tryNumber;

        System.out.println(CMD_QUESTION_NAME);
        playersNameString = Console.readLine();

        playerNamesList = new ArrayList<String>(
                Arrays.asList(playersNameString.split(SEP_PLAYER_STRING)));

        System.out.println(CMD_QUESTION_NUMBER);
        tryNumber = Integer.parseInt(Console.readLine());

        racingData.saveRacingData(playerNamesList, tryNumber);
    }

}
