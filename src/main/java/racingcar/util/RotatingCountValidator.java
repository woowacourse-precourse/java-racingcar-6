package racingcar.util;

public class RotatingCountValidator {
    public boolean check(String racingCount) {
        return isNull(racingCount) && isSize(racingCount) && isNumber(racingCount);
    }

    private boolean isNumber(String racingCount) {
        String regex = "[0-9]+";
        if(racingCount.matches(regex)){
            return true;
        }
        throw new IllegalArgumentException("순수 숫자만 존재하지 않습니다.");
    }

    private boolean isSize(String racingCount) {
        int hundredMillion = 9;

        if(!racingCount.isEmpty() && racingCount.length() <= hundredMillion){
            return true;
        }
        throw new IllegalArgumentException("정수 범위내로 입력해주세요.");
    }

    private boolean isNull(String racingCount) {
        if(racingCount != null && !racingCount.trim().isEmpty()){
            return true;
        }
        throw new IllegalArgumentException("입력이 비어있습니다.");
    }
}
