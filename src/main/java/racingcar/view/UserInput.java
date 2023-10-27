package racingcar.view;

public class UserInput {
    public String userInputCarName;
    public int gameCount;

    public UserInput(String userInputCarName, int gameCount) {
        validateInput(userInputCarName);//여기서 확인 후 담기
        this.userInputCarName = userInputCarName;
        this.gameCount = gameCount;
    }

    //2) 사용자 입력에 대한 예외처리
    public void validateInput(String carName) throws IllegalArgumentException {
        //1) 각 이름 길이 5초과 시 예외
        for (String x : carName.split(",")) {
            if (x.length() > 5) {
                throw new IllegalArgumentException("경주할 자동차 이름의 길이는 5이하여야 합니다.");
            }
        }
        //2) 각 이름에 " " 공백 포함 시 예외
        for (String x : carName.split(",")) {
            if (x.contains(" ")) {
                throw new IllegalArgumentException("경주할 자동차 이름에 공백이 포함되면 안됩니다.");
            }
        }
    }

}
