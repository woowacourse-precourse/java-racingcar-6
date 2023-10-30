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

    private boolean canGo(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        if(randomNum >= 4){
            return true;
        }
        return false;
    }

}
