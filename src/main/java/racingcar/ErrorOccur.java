package racingcar;

public class ErrorOccur {

    //잘못된 입력 에러처리 클래스
    public String[] ReturnCarName(String[] carNames){
        for(String car: carNames){
            returnError(car);
        }
        return carNames;
    }
    public void returnError(String carName) {
        int carLen = carName.length();
        try {
            if(carLen>5){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}
