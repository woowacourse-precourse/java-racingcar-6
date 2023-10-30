package constant;

//Enum 셋업
// 0 9 4 magic numbers
// 경주
// 시도
// 결과
// 진척도 -
// :
// 최종우승자


public enum GameUserInterface {
    // %d 등 인수 작업 가능
    ASK_CAR_NAME("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)"),
    ASK_GAME_TRYS("시도할 회수는 몇회인가요?"),
    CAR_NAME_COLON(":"),
    RACING_RESULT("실행 결과"),
    RACING_DISTANCE("-"),
    RACING_WINNER("최종 우승자");

    private final String UserInterface;

    GameUserInterface(String UserInterface) {
        this.UserInterface = UserInterface;
    }
    String getUserInterface() {
        return UserInterface;
    }
}

