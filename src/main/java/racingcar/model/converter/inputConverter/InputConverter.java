package racingcar.model.converter.inputConverter;

/**
 * 입력받은 String을 특정한 자료형으로 변환해주는 Converter를 나타낸다.
 *
 * @param <T> 입력받은 String이 변환될 자료형
 */
public interface InputConverter<T> {

    /**
     * 입력받은 String을 자료형 T(제너릭)로 변환한다.
     *
     * @param input 변환될 String
     * @return T 자료형으로 변환된 값
     * @throws IllegalArgumentException 입력 받은 String이 T 자료형으로 변환 불가 시
     */
    T convertToType(String input);
}
