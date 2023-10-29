package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
public class Racing {

    public void racingProcess(){

        //랜덤 숫자 입력
        int number = Randoms.pickNumberInRange(0,9);
        System.out.println(number);


        //랜던 숫자 체크 -> 전진 처리
        int location = 0;
        if(moveForward(number)){
            location++;
        }
        System.out.println(location);

        //실행 결과 출력
    }

    private boolean moveForward(int number){

        if(number > 3){
            return true;
        }

        return false;
    }
}
