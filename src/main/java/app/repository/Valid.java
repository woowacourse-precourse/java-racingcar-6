package app.repository;


public class Valid {

    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int MAX_PLAY_COUNT = 10;
    public static final int LIMIT_CAR_COUNT = 10;

    public void validCarName(String text) {
        if (text == null || text.isEmpty() || text.isBlank()){
            throw new IllegalArgumentException("값을 입력해야합니다.");
        }
        String[] split = text.split(",");
        if (split == null || split.length == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }
        for (String carName : split) {
            if (carName.length() >= MAX_CAR_NAME_LENGTH){
                throw new IllegalArgumentException("자동차의 이름은 " + MAX_CAR_NAME_LENGTH + "자 이하만 가능합니다.");
            }
            if (carName == null || carName.isEmpty() || carName.isBlank() || "null".equals(carName)) {
                throw new IllegalArgumentException("자동차 이름을 정확히 입력해주세요.");
            }
        }
        if (split.length > LIMIT_CAR_COUNT) {
            throw new IllegalArgumentException("경주할 수 있는 자동차는 " + LIMIT_CAR_COUNT + "대 이하입니다.");
        }
    }

    public void validCount(String text) {
        if (text == null || text.isEmpty() || text.isBlank()) {
            throw new IllegalArgumentException("빈칸은 작성할 수 없습니다.");
        }
        String notNumber = text.replaceAll("[0-9]", "");
        if (!notNumber.isEmpty()) {
            throw new IllegalArgumentException("숫자만 작성할 수 있습니다.");
        }
        if (text.equals("0")){
            throw new IllegalArgumentException("0 이상의 숫자를 작성해야합니다");
        }
        if (Integer.parseInt(text) > MAX_PLAY_COUNT) {
            throw new IllegalArgumentException("최대 " + MAX_PLAY_COUNT + "게임까지 할 수 있습니다.");
        }
    }
}
