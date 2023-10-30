package racingcar;

import java.util.HashMap;
import  java.util.Map;
import camp.nextstep.edu.missionutils.Console;
public class Input {

    public static String[] getCarName(){
        String getCarAllName = Console.readLine();
        String [] carName = getCarAllName.split(",");
        //글자수 5글자 이하 예외 처리
        for(int i = 0; i <carName.length;i++){
            if(carName[i].length()>5){
                throw new IllegalArgumentException("프로그램을 종료합니다.");
            }
        }
        return carName;
        }

        public static int getGameRoundNum(){
        String GameRoundNum = Console.readLine();
        return Integer.parseInt(GameRoundNum);
        }



}



