package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class Output {
    public int randomNumber() {
        int randNum = Randoms.pickNumberInRange(0, 9);
        return randNum;
    }
    public void totalPrint(Map<String,Integer> parkingLot,String[] carlist) {
        for(int i=0;i<parkingLot.size();i++){
            //하나씩 출력
        }
    }
}
