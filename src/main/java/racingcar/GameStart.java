package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class GameStart {
    private String cars;
    private String[] carsName;
    private int[] carsScore;
    private String[] carsScoreString;
    public GameStart(){
        cars = Console.readLine();
        carsName = cars.split(",");

        carsScore = new int[carsName.length];
        carsScoreString = new String[carsName.length];
        Arrays.fill(carsScoreString,"");
    }


    private int repeatCount(){
        String repeat = Console.readLine();
        //에러 체크
        return Integer.parseInt(repeat);
    }


    private boolean canGo(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        if(randomNum >= 4){
            return true;
        }
        return false;
    }

    private ArrayList<String> winner(int win){
        ArrayList<String> winner = new ArrayList<String>();
        for (int i = 0; i < carsScore.length; i++) {
            if(carsScore[i] == win){
                winner.add(carsName[i]);
            }
        }
        return winner;
    }


}
