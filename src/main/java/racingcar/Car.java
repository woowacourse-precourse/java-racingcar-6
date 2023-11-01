package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    String state = "";
    public int drawNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public String decideGo(int drawnumber){
        if (drawnumber >= 4){
            return this.state += "-";
        }
        if (drawnumber < 4){
            return this.state;
        }
        return "버그";
    }
//테스트 코드 작성부터 하자.

}
