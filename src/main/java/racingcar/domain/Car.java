package racingcar.domain;

/**
 * 자동차 경주 게임에서 사용되는 Car 클래스.
 */
public class Car {
    private String name;
    private int position = 0;

    /**
     * 자동차 이름을 입력받아 Car 객체를 생성합니다.
     *
     * @param name 자동차의 이름. 이름 길이 및 형식에 대한 제약 조건을 확인해야 합니다.
     */
    public Car(String name) {
        this.name = name;
    }

    /**
     * 주어진 조건에 따라 자동차의 위치를 이동시킵니다.
     *
     * @param shouldMove 자동차를 이동시킬지의 여부. true일 경우 한 칸 이동, false일 경우 이동하지 않습니다.
     */
    public void move(boolean shouldMove) {
        if (shouldMove) {
            position++;
        }
    }

    /**
     * 현재 자동차의 위치 값을 반환합니다.
     *
     * @return 자동차의 현재 위치
     */
    public int getPosition() {
        return position;
    }

    /**
     * 자동차의 이름을 반환합니다.
     *
     * @return 자동차의 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 현재 자동차의 위치를 표현하는 문자열을 반환합니다.
     *
     * @return 자동차의 위치를 표현하는 문자열. 예) "----"
     */
    public String getPositionRepresentation() {
        return generatePositionString(this.position);
    }

    /**
     * 주어진 위치값에 따른 위치 표현 문자열을 생성하여 반환합니다.
     *
     * @param position 위치 값
     * @return 위치 값을 표현하는 문자열
     */
    public static String generatePositionString(int position) {
        return "-".repeat(position);
    }
}


