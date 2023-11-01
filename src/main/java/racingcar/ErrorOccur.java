package racingcar;

public class ErrorOccur {

    //잘못된 입력 에러처리 클래스
    public String[] ReturnCarName(String[] carNames){
        for(String car: carNames){
            returnCarError(car);
        }
        return carNames;
    }

    public String ReturnTryNum(String inputNum){
        returnNumError(inputNum);
        return inputNum;
    }
    public void returnCarError(String carName) {
        int carLen = carName.length();
        try {
            if(carLen>5 || carName.isEmpty()){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
    public void returnNumError(String inputNum) {
        try {
            if(inputNum==null||inputNum.isEmpty()){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        try {
            if(!isNum(inputNum)){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
//
    }
    public static boolean isNum(String inputNum) {
        if (inputNum == null) {
            return false;
        }
        try {
            Integer.parseInt(inputNum);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
