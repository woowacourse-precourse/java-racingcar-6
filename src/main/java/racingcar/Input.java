package racingcar;

import java.util.HashMap;
import java.util.Map;
import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String[] getCarName() {
        String getCarAllName = Console.readLine();
        String[] carName = getCarAllName.split(",");
        Exception.checkOverWriteUserName(carName);
        return carName;
    }


    public static int getGameRoundNum() {
        String GameRoundNum = Console.readLine();
        Exception.checkOnlyNumber(GameRoundNum);
        Exception.ifUserZeroNumber(GameRoundNum);
        return Integer.parseInt(GameRoundNum);
    }

}



