package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class PlayResult {
    // 실행 결과 출력 메소드
    public void getResult(String[] names, String[] results){
        for (int i = 0; i < names.length; i++) {
            int r = Randoms.pickNumberInRange(0, 9);
            if (r >= 4)
                results[i] += "-";
            System.out.println(results[i]);
        }
    }
}
