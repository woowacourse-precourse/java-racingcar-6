package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private final String name;
    private int position;

    public Car(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public void move() {
        //0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우에 자동차는 전진한다.
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public void showCar() {
        System.out.printf("%s : %s\n",name,makeBar());
    }

    private String makeBar() {
        return "-".repeat(position);
    }

    private int getPosition() {
        return position;
    }

    public void showName() {
        System.out.print(name);
    }

    @Override
    public int compareTo(Car car) {
        if(car == null) {
            throw new NullPointerException();
        }

        return getPosition() - car.getPosition();
    }
}
