package racingcar.view;

import static racingcar.util.GameConstants.CAR_NAME_DELIMITER;
import static racingcar.util.GameConstants.CAR_NAME_DELIMITER_KOR;
import static racingcar.util.GameConstants.OUTPUT_TOKEN;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputViewImpl implements OutputView{
    @Override
    public void displayCarNameInputNotice() {
        String output = "경주할 자동차 이름을 입력하세요.(이름은 " + CAR_NAME_DELIMITER_KOR + "(" + CAR_NAME_DELIMITER + ") 기준으로 구분)";
        System.out.println(output);
    }

    @Override
    public void displayMoveCountInputNotice() {
        String output = "시도할 횟수는 몇회인가요?";
        System.out.println(output);
    }

    @Override
    public void displayRaceStatus(List<Map<String, Integer>> result) {
        String output = "\n실행 결과";
        System.out.println(output);

        for (Map<String, Integer> eachCountResult : result) {
            for (Entry<String, Integer> eachCar : eachCountResult.entrySet()) {
                String eachOutput = eachCar.getKey() + " : " + convertToToken(eachCar.getValue());
                System.out.println(eachOutput);
            }
            System.out.println();
        }
    }

    private String convertToToken(Integer value) {
        String token = "";
        for (int cnt = 0; cnt < value; cnt++) {
            token += OUTPUT_TOKEN;
        }
        return token;
    }

    @Override
    public void displayWinners(List<String> winners) {
        String output = "최종 우승자 : ";
        output += String.join(", ", winners);
        System.out.println(output);
    }
}
