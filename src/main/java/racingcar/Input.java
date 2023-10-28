package racingcar;

import java.util.HashMap;
import  java.util.Map;
import camp.nextstep.edu.missionutils.Console;
public class Input {

    public static String[] getCarName(){
        String getCarAllName = Console.readLine();
        String [] carName = getCarAllName.split(",");
        return carName;
        }

        public static int getGameRoundNum(){
        String GameRoundNum = Console.readLine();
        return Integer.parseInt(GameRoundNum);
        }



}



