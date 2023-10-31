package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import pojo.RacingCar;

public class RapsResult {

    RacingCar rc;

    public RapsResult(RacingCar rc) {
        this.rc = rc;
    }

    //숫자가 4 이상일 경우 true값 반환
    public boolean reader(int num){
        if(num >= 4){
            return true;
        }
        return false;
    }
    //자동차의 위치값을 1 더해줌
    public void changeCarStatus(boolean flag){
        if(flag){
            rc.distanceFoward();
        }
    }
    //자동차의 최종 이동 거리에 대한 결과값 반환
    public String resultText(){
        return rc.getName() + " : " + distanceText();
    }

    //자동차의 이동 거리 출력값을 반환
    public String distanceText(){
        StringBuilder text = new StringBuilder();
        for(int i=0; i<rc.getDistance(); i++){
            text.append("-");
        }
        return text.toString();
    }

    //랜덤값을 생성해서 전진할지 멈출지 알려주는 값을 반환
    public boolean determineForward() {
        int num = Randoms.pickNumberInRange(0, 9);
        return reader(num);
    }

    //최종 결과를 반환
    public String forwardOrNot(){
        boolean forward = determineForward();
        changeCarStatus(forward);
        return resultText();
    }

}
