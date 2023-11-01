package racingcar.view;

import static racingcar.util.GameConstants.CAR_NAME_DELIMITER;
import static racingcar.util.GameConstants.CAR_NAME_DELIMITER_KOR;
import static racingcar.util.GameConstants.OUTPUT_TOKEN;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * {@code OutputView}의 구현부이다.
 * 메시지와 게임 현황을 사용자에게 보여준다.
 */
public class OutputViewImpl implements OutputView{

    /**
     * 사용자에게 자동차의 이름을 입력하라는 메시지를 출력한다.
     */
    @Override
    public void displayCarNameInputNotice() {
        String output = "경주할 자동차 이름을 입력하세요.(이름은 " + CAR_NAME_DELIMITER_KOR + "(" + CAR_NAME_DELIMITER + ") 기준으로 구분)";
        System.out.println(output);
    }

    /**
     * 사용자에게 총 이동 횟수를 입력하라는 메시지를 출력한다.
     */
    @Override
    public void displayMoveCountInputNotice() {
        String output = "시도할 횟수는 몇회인가요?";
        System.out.println(output);
    }

    /**
     * 각각의 자동차의 이름과 토큰을 이용한 위치로 경주 현황을 보여준다.
     *
     * @param result 총 이동 횟수 동안 각각의 횟수에 대한 자동차 경주 결과를 담은 map의 List
     */
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

    /**
     * numerical한 값을 토큰으로 바꿔주는 Helper 메소드이다.
     *
     * @param value 토큰이 필요한 개수
     * @return 연결된 토큰의 문자열
     */
    private String convertToToken(Integer value) {
        String token = "";
        for (int cnt = 0; cnt < value; cnt++) {
            token += OUTPUT_TOKEN;
        }
        return token;
    }

    /**
     * 경주의 우승 자동차들의 이름을 출력한다.
     *
     * @param winners 우승 자동차들의 이름을 담은 list
     */
    @Override
    public void displayWinners(List<String> winners) {
        String output = "최종 우승자 : ";
        output += String.join(", ", winners);
        System.out.println(output);
    }
}
