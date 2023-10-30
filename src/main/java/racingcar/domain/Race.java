package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Race {
    public static Integer numberOfGameRound(){
        System.out.println("시도할 횟수는 몇회인가요?");
        Integer countOfGame = Integer.valueOf(Console.readLine());
        return countOfGame;
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
