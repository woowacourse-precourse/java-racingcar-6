package racingcar;

import static racingcar.constants.*;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    //랜덤 숫자 생성하기
    public int getRandomNumber(){
        int randomNum = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        return randomNum;
    }
    
    //전진
    public void locate(int randomNum){
        int location = 0;
        if (randomNum >= GO_RANDOM_NUMBER) {
            location += 1;
        }
    }
}
