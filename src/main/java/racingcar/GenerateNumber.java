package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateNumber {

    public void GenerateRandomNumber(String[] players){
        int[] pickNumbers = new int[players.length];
        for (int i=0; i<players.length; i++){
            pickNumbers[i] = Randoms.pickNumberInRange(0,9);
        }
    }

}
