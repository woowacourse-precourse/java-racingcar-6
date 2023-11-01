package racingcar;

import racingcar.view.OutputView;

/**
 * 자동차 객체를 생성하고, 자동차의 이름과 전진 횟수를 관리하는 클래스
 * 다른 자동차 객체를 받아 전진 횟수를 비교할 수도 있다.
 */
public class Car implements Comparable<Car> {
    private final String name;
    private int movePoint = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar() {
        movePoint += 1;
    }

    /** 자동차 이름과, 전진 횟수(-)를 문자열로 만들어 반환 */
    public String getForwardMoveCount() {
        return OutputView.getHyphens(name, movePoint);
    }

    /** 다른 자동차 객체와 movePoint를 비교하는 메소드 */
    @Override
    public int compareTo(Car that) {
        return this.movePoint - that.movePoint;
    }

    public boolean haveSamePoint(Car that) {
        return this.movePoint == that.movePoint;
    }

    public String getName() {
        return this.name;
    }
}