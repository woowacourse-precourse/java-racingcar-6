package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Go_Stop_Selector implements Move_Selector {
    private static final int MIN_MOVABLE_NUMBER = 4;
    @Override
     public boolean Go_or_Stop(){
         return Get_Random_Number()>=MIN_MOVABLE_NUMBER;
     }
     private int Get_Random_Number(){
         return Randoms.pickNumberInRange(0, 9);
     }
}
