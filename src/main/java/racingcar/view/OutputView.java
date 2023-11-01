package racingcar.view;

import java.util.List;
import java.util.Map;

/**
 * 사용자의 출력 규칙을 나타내는 interface이다.
 */
public interface OutputView {

    /**
     * 사용자에게 자동차의 이름을 입력하라는 메시지를 출력한다.
     */
    void displayCarNameInputNotice();

    /**
     * 사용자에게 총 이동 횟수를 입력하라는 메시지를 출력한다.
     */
    void displayMoveCountInputNotice();

    /**
     * 사용자에게 자동차 경주 결과를 출력한다.
     *
     * @param result 총 이동 횟수 동안 각각의 횟수에 대한 자동차 경주 결과를 담은 map의 List
     */
    void displayRaceStatus(List<Map<String, Integer>> result);

    /**
     * 사용자에게 자동차 경주의 우승자를 출력한다.
     *
     * @param winners 우승 자동차들의 이름을 담은 list
     */
    void displayWinners(List<String> winners);
}
