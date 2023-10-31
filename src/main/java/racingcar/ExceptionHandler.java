package racingcar;

public class ExceptionHandler {

    /**
     * 사용자가 입력한 자동차 이름 유효성 체크 함수
     */
    public void validateUserInput(String userInput) {
        String[] nameList = userInput.split(","); // 이름 분리
        for (String name : nameList) {
            if(name.length() > 5) { // 자동차 이름의 길이가 5자를 넘어간 경우
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }
}
