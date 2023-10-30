package racingcar.view;

import java.util.List;
import racingcar.dto.CarDTO;
import racingcar.dto.RoundDTO;

public class OutputView {
    public void displayResult(List<RoundDTO> rounds) {
        String result = makeScoreBoard(rounds);

        System.out.print(result);
    }

    public void displayWinners(List<String> winners) {
        String string = String.join(",", winners);
        String result = String.format("최종 우승자 : %s\n", string);

        System.out.print(result);
    }

    
    // 게임 결과를 나타내는 문자열 생성
    private String makeScoreBoard(List<RoundDTO> rounds) {
        StringBuilder result = new StringBuilder();
        result.append("\n실행결과\n");

        for (RoundDTO round : rounds) {
            List<CarDTO> states = round.getStates();

            for (CarDTO state : states) {
                String name = state.getName();
                String position = "-".repeat(state.getPosition());
                String string = String.format("%s : %s\n", name, position);

                result.append(string);
            }
            result.append("\n");
        }
        return result.toString();
    }

}
