package racingcar.model.converter.inputConverter;

public class InputConverterImpl implements InputConverter<Long>{
    @Override
    public Long convertToType(String input) {
        try {
            return Long.parseLong(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("자료형에 맞는 값을 입력해주세요.");
        }
    }
}
