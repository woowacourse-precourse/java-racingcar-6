package racingGame;

import java.util.List;

public class RaceUtil {

    // 이름 길이 5자리 이하 여부 검사
    public void checkNameLength(List<RaceVO> carNames, String[] names) {
        for(String tempName : names) {
            if(tempName.length() > 5) {
                throw new IllegalArgumentException();
            } else {
                RaceVO racer = new RaceVO(tempName, 0);
                carNames.add(racer);
            }
        }
    }
}
