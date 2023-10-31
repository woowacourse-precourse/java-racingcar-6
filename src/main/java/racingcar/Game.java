package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Game {
    public static int[] raceInit(ArrayList<String> userArray,int[] raceCount) {
        for (int k = 0; k < userArray.size(); k++) {
            int raceNumber = Randoms.pickNumberInRange(0, 9);
            if (raceNumber >= 4) {
                raceCount[k]++;
            }
        }
        return raceCount;
    }
    public void printRace(ArrayList<String> userArray,int[] raceCount){
        for (int a = 0 ; a < userArray.size();a++){

            System.out.print(userArray.get(a)+" : ");
            for (int j = 0; j < raceCount[a]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

}

