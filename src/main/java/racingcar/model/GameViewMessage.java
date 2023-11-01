package racingcar.model;

public enum GameViewMessage {
    writeCarNameMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    writeRaceLengthMessage("시도할 회수는 몇회인가요?"),
    outputFirstLineMessage("실행결과"),
    outputWinnerMessage("최종 우승자"),
    colonString(":"),
    spaceBar(" ");


    private final String message;

    GameViewMessage(String message) {

        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
