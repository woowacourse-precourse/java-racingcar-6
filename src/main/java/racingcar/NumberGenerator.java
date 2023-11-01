package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public int createRandomNumber(){
        // 랜덤값(0-9)을 생성한다.
        int randomNumber = Randoms.pickNumberInRange(0,9);
        return randomNumber;
    }
}
