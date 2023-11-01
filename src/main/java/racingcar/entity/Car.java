package racingcar.entity;

// 게임에서 사용하는 자동차 정보를 저장하기 위한 클래스
public class Car {
    private final int LOCATION_CONSTRAINT = 4; // 전진 조건
    private final String LOCATION_TOKEN = "-"; // 자동차의 위치를 이미지로 나타내는데에 활용하는 값
    private String carName; // 자동차 이름
    private int location; // 자동차의 위치

    public Car(final String carName) {
        this.carName = carName;
        this.location = 0;
    }

    private Car() {
    }

    public String getCarName() {
        return this.carName;
    }

    public int getLocation() {
        return this.location;
    }

    // 특정 조건에 부합하는 경우 전진, 그렇지 않을 경우에는 현재 위치 유지
    public void moveForward(final int resultCount) {
        if(resultCount >= LOCATION_CONSTRAINT) {
            this.location++;
        }
    }

    private String convertLocation() {
        if(this.location == 0) {
            return "";
        }

        return LOCATION_TOKEN.repeat(location); // 자동차의 위치에 따른 결과 반환
    }

    @Override
    public String toString() {
        return this.carName + " : " + convertLocation();
    }
}