package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Race {
    public static Integer numberOfGameRound(){
        System.out.println("시도할 횟수는 몇회인가요?");
        Integer countOfGame = Integer.valueOf(Console.readLine());
        return countOfGame;
    }
    public static void playingMainGame(){
        List<String> carList = Car.makeRacingCarList();
        int[] goCount = new int[carList.size()];
        int round = numberOfGameRound();
       repeatRacing(round,carList,goCount);
       Winner.findWinners(carList,goCount);
    }

    public static void repeatRacing(int round,List<String> carList,int[] goCount){
        for(int i = 0 ; i<round;i++){
            racingByRandomNumber(carList,goCount);
            System.out.println();
        }
    }
    public static void racingByRandomNumber(List<String> carList,int[] goCount){
        for(int i = 0 ; i<carList.size(); i++){
            int goStopNumber = Randoms.pickNumberInRange(0,9);
            if(goStopNumber>=4){
                goCount[i]++;
            }
            System.out.println(carList.get(i)+" : "+ "-".repeat(goCount[i]));
        }
    }




}
