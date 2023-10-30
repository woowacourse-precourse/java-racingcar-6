package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RapsResult {

    RacingCar rc;

    public RapsResult(RacingCar rc) {
        this.rc = rc;
    }

    public String forwardOrNot(){
        int num = Randoms.pickNumberInRange(0,9);
        boolean result = reader(num);
        changeCarStatus(result);
        return resultText();
    }

    public boolean reader(int num){
        if(num >= 4){
            return true;
        }
        return false;
    }

    public void changeCarStatus(boolean flag){
        if(flag){
            rc.distanceFoward();
        }
    }

    public String resultText(){
        return rc.getName() + " : " + distanceText();
    }

    public String distanceText(){
        StringBuilder text = new StringBuilder();
        for(int i=0; i<rc.getDistance(); i++){
            text.append("-");
        }
        return text.toString();
    }
}
