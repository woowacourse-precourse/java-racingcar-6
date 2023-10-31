package racingcar.model;

/**
 * 양수 자료형
 */
public class Number {

    private final int number;

    /**
     * 정수 문자열을 입력받고, 양수인지 검증 후 저장한다.
     *
     * @param input String 타입의 정수
     */
    public Number(String input) {
        this.number = validationNumber(input);
    }

    /**
     * 입력한 양수를 반환한다.
     *
     * @return 저장되어 있는 정수를 반환한다.
     */
    public int getNumber() {
        return number;
    }

    /**
     * 양수가 맞는지 검증한다.
     *
     * @param input 사용자에게 입력받은 데이터를 받는다.
     * @return 양수를 정수형으로 반환한다.
     */
    private static int validationNumber(String input) {
        try {
            int num = Integer.parseInt(input);
            if (num < 1) {
                throw new IllegalArgumentException("0 이하의 수를 입력할 수 없습니다.");
            }

            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닙니다.");
        }
    }
}
