package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Map;

public class GameRule {

    //랜덤한 수 출력하기
    public static int getRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        return randomNumber;
    }

    //랜덤 수가 4이상인지 판별하기
    public static boolean checkRandomNumber(int randomNumber) {
        if(randomNumber >= 4) {
            return true;
        }
        return false;
    }

    //랜덤수를 통해 전진조건이 된 차 전진하기
    public static Map<String, Integer> updateCarRacingRecord(List<String> carList, Map<String, Integer> carRacingRecord){
        for(String carName : carList) {
            int randomNumber = getRandomNumber();
            if(checkRandomNumber(randomNumber)) {
                carRacingRecord.put(carName, carRacingRecord.get(carName)+1);
            }
        }
        return carRacingRecord;
    }

}
