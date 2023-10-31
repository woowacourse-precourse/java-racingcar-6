package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Get {

    public static String[] carName(){
        return readLine().split(",");
    }

    public static int playCount(){
        return Integer.parseInt(readLine());
    }
}


