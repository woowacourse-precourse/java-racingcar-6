package racingcar.domain;

import racingcar.view.OutputView;

import java.util.List;

public enum Message {

    READ_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    READ_PROGRESS_COUNT("시도할 회수는 몇회인가요?"),
    EXECUTION_RESULT("실행 결과"),
    GAME_TOTAL_RESULT("최종 우승자 : ");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getProgressMessage(StringBuilder sb) {
        return "\n" + this.message + "\n" + sb.toString();
    }

    public String getWinnerMessage(List<String> winnerCarNameList) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.message);
        winnerCarNameList.stream().forEach(name -> sb.append(name));
        sb.append("\n");

        return sb.toString();
    }

}
