package service;

import model.CarInformation;
import static model.Constants.CARNAME_MAXLENGTH;

public class IllegalLogic {

    CarInformation carInformation = new CarInformation();
    RacingCarGameLogic racingCarGameLogic = new RacingCarGameLogic();
    public void processingIllegalLogic(String inputString){
        String[] splitName=splitCarName(inputString);
        if(stringLengthCheck(splitName)){
            racingCarGameLogic.insertCarName(splitName);
        }
    }

    public String[] splitCarName(String inputString){
        String[] splitName=inputString.split(",");
        if(splitName.length==1){
            throw new IllegalArgumentException("한대만 입력하였습니다.");
        }
        return splitName;
    }

    private boolean stringLengthCheck(String[] splitName){
        for(int i = 0; i<splitName.length; i++){
            compareNameLength(splitName[i]);
        }
        return true;
    }

    private void compareNameLength(String carName){
        if(carName.isEmpty() ||carName.length()>CARNAME_MAXLENGTH){
            throw new IllegalArgumentException("차량의 이름은 1자이상 5자이하 입니다.");
        }
    }

    public int checkInputNumberAttempts(String inputNumberAttempts) {
        for (int i = 0; i < inputNumberAttempts.length(); i++) {
            if(!Character.isDigit(inputNumberAttempts.charAt(i))||inputNumberAttempts.charAt(i)=='0') {
                throw new IllegalArgumentException("숫자가 아니거나 0을 입력하였습니다.");
            }
        }
        return Integer.parseInt(inputNumberAttempts);
    }
}
