package racingcar.domain;

public class Car {
    private String carName;
    private int position;

    public Car(String name) {
        this.carName = name;
        this.position = 0;
    }
    // 전진
    public void move(int number) {
        if (number >= 4 && number <= 9) {
            position++;
        }
    }
    // 자동차 이름
    public String getName() {
        return carName;
    }
    // 위치 반환
    public int getPosition() {
        return position;
    }
    // view에 출력하기 위한 시각화 도구
    public String getPositionBar() {
        StringBuilder positionBar = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionBar.append('-');
        }
        return positionBar.toString();
    }
}
