package racingcar.model.converter.inputConverter;

/**
 * {@code InputConverter}의 구현부이다.
 * String 값을 Long으로 변환한다.
 */
public class LongConverter implements InputConverter<Long>{

    /**
     * 주어진 String형 input을 Long으로 변환한다.
     * <p>
     *     💡 : 이 메소드는 {@link Long#parseLong(String)}에 의존하고 있다.
     *     입력받은 String이 유효한 Long이 아닐 경우 IllegalArgumentException을 반환한다.
     * </p>
     *
     * @param input 변환될 String
     * @return Long 값으로 변환
     * @throws IllegalArgumentException 입력 받은 String이 Long으로 변환 불가능할 대
     */
    @Override
    public Long convertToType(String input) {
        try {
            return Long.parseLong(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("자료형에 맞는 값을 입력해주세요.");
        }
    }
}
