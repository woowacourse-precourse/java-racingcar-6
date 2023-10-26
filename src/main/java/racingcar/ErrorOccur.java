package racingcar;

public class ErrorOccur {
    private final String[] carList;

    //잘못된 입력 에러처리 클래
    public ErrorOccur(String[] carList){
        this.carList = carList;
    }

    public String[] returnCarList() {
        for(String car : carList){
            int carLen = car.length();
            try {
                if(carLen>5){
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            }
        }
        return carList;
    }
}
