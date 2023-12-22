package racingcar.dto;

public class CountRequestDto {

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = validateNumberFormat(count);
    }

    private int validateNumberFormat(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
