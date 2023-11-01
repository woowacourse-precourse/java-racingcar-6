package racingcar;

import static racingcar.Const.*;
import camp.nextstep.edu.missionutils.Randoms;
public class CarState {

    private int moveCount = 0;
    private final String carName;

    // 차량 이름, 이동 카운트 설정
    // 랜덤수에 따라 차량의 무브 카운트 파악 함수 작성

    public CarState(String name) {
        this.carName = name;
    }

    public void move(){
        if(Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER) >= MIN_NUMBER_REQUIRED_TO_MOVE_A_CAR ) {
            moveCount++;
        }
    }
    
    public String getName(){
        return carName;
    }

    public int getMoveCount(){
        return moveCount;
    }



}
