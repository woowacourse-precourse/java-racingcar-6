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
            routePrint(carlist[i],parkingLot.get(carlist[i]));
        }
        System.out.println();
    }

    public void routePrint(String carName,int carDistance) {
        String distance = "";
        for (int i = 0; i < carDistance; i++) {
            distance += "-";
        }
        System.out.println(carName+" : "+distance);
    }
}
