package racingcar.domain;

/**
 * <p>자동차 경주 게임에서 사용되는 자동차를 표현하는 도메인 클래스입니다.</p>
 */
public class Car {

    private final int MOVE_BOUND = 4;

    /**
     * 자동차의 이름을 나타냅니다.
     */
    private final String name;

    /**
     * 자동차의 현재 위치를 나타냅니다.
     */
    private int position;

    /**
     * <p>주어진 이름을 가진 {@code Car} 객체를 생성합니다.</p>
     *
     * @param name 자동차의 이름
     */
    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    /**
     * <p>자동차의 이름을 반환합니다.</p>
     *
     * @return 자동차의 이름
     */
    public String getName() {
        return name;
    }

    /**
     * <p>자동차의 현재 위치를 반환합니다.</p>
     *
     * @return 자동차의 현재 위치
     */
    public int getPosition() {
        return position;
    }

    /**
     * <p>자동차의 위치를 1만큼 증가시킵니다.</p>
     */
    private void move() {
        position++;
    }

    /**
     * <p>주어진 랜덤 숫자에 따라 자동차의 전진 여부를 판단하고 전진할 경우 {@link #move()} 메소드를 호출합니다.</p>
     * <p>랜덤 숫자가 {@link #MOVE_BOUND} 이상일 경우에만 전진합니다.</p>
     *
     * @param randomNumber 전진 여부를 판단하기 위한 랜덤 숫자
     */
    public void tryMove(int randomNumber) {
        if (randomNumber >= MOVE_BOUND) {
            move();
        }
    }
}
