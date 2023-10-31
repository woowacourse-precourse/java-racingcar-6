package racingcar.view;

import java.util.List;
import racingcar.dto.CarDTO;
import racingcar.dto.RoundDTO;

public class OutputView {
    private StringBuilder result = new StringBuilder();


    public void displayResult(List<RoundDTO> rounds, List<String> winners) {
        result.append("\n실행결과\n");
        convertResultToString(rounds);
        appendWinners(winners);

        System.out.print(result);
    }


    // result에 게임 결과를 문자열 형태로 작성
    private void convertResultToString(List<RoundDTO> rounds) {
        for (RoundDTO round : rounds) {
            List<CarDTO> states = round.getStates();

            appendRoundStates(states);
        }
    }

    // result에 라운드별 결과 추가
    private void appendRoundStates(List<CarDTO> states) {
        for (CarDTO state : states) {
            String name = state.getName();
            String position = "-".repeat(state.getPosition());
            String string = String.format("%s : %s\n", name, position);

            result.append(string);
        }
        result.append("\n");
    }

    // result에 승리자 목록 추가
    private void appendWinners(List<String> winners) {
        String tmp = String.join(",", winners);
        String string = String.format("최종 우승자 : %s\n", tmp);

        result.append(string);
    }

}
