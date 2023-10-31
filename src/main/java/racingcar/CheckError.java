package racingcar;

public class CheckError {
    public void checkCarName(String[] carName) {
        for(String str : carName) {
            isEmptyCarName(str);
            isOverCarName(str);
            IsIncludeNotText(str);
        }
    }

    public static void isEmptyCarName(String carName) {
        if(carName.isEmpty())
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
    }

    public static void isOverCarName(String carName) {
        if(carName.length() > 5)
            throw new IllegalArgumentException("1 ~ 5 글자의 자동차 이름을 입력하세요.");
    }

    public static void IsIncludeNotText(String carName) {
        if(!carName.matches("[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝]*"))
            throw new IllegalArgumentException("특수문자를 제외한 문자와 숫자로 이루어진 이름을 입력하세요.");
    }
}
