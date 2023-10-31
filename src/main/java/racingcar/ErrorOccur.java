package racingcar;

public class ErrorOccur {

    //잘못된 입력 에러처리 클래스
    public String[] ReturnCarName(String[] carNames){
        for(String car: carNames){
            returnCarList(car);
        }
        return carNames;
    }
    public void returnCarList(String carName) {
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
