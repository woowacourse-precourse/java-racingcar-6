package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Get {

    // 사용자가 입력한 차 이름 받아오기
    public static String[] carName(){
        return readLine().split(",");
    }

    // 사용자가 입력한 실행 횟수 받아오기
    public static int playCount(){
        return Integer.parseInt(readLine());
    }
}


