package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Production {


    static List<String> makeRacingCar(String carName) {
        // 입력받은 자동차 이름 리스트로
        return Arrays.asList(carName.split(","));
    }


    static int trialNumber(String strTrialNum) {
        int trialNum;
        try {
            trialNum = Integer.parseInt(strTrialNum);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("시도할 횟수는 정수여야 합니다.");
        }
        if (trialNum < 0) throw new IllegalArgumentException("시도할 횟수는 자연수여야 합니다.");

        return trialNum;
    }

    static int makeRandomNum() {

        return Randoms.pickNumberInRange(0,9);
    }

    static List<Integer> implementMakeRandomNum(List<String> carList) {
        // 자동차마다 랜덤 숫자 생성 (자동차 수만큼 makeRandomNum 호출)
        List<Integer> RandomNumForCars = new ArrayList<Integer>();

        for (int i=0; i < carList.size(); i++) {
            int RandomNumForIthCar = makeRandomNum();
            RandomNumForCars.add(RandomNumForIthCar);
        }

        return RandomNumForCars;
    }

    static List<String> makeEmptyList(int length) {
        if (length < 0)
            throw new IllegalArgumentException("배열의 길이는 0이상이어야 합니다.");

        List<String> list = new ArrayList<String>();
        for (int i=0; i<length; i++) {
            list.add("");
        }
        return list;
    }
}
