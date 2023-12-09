package racingcar.Model;

public class Car {
    public int getTryNumber() {
        return tryNumber;
    }

    public void setTryNumber(int tryNumber) {
        this.tryNumber = tryNumber;
    }

    public int tryNumber;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String carName; //carSize 크기의 문자열을 담을 수 있는 배열 선언 및 생성



    public String[] getCarList() {
        return carList;
    }

    public void setCarList(String[] carList) {
        this.carList = carList;
    }

    public String[] carList;    //사용자가 입력한 차 이름 리스트


}
