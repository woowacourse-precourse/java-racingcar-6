package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Race;

public class RaceView {

    /**
     * 사용자에게 공백 없는 쉼표(,)로 구분된 일련의 자동차 이름을 입력할 것을 요구합니다.
     * 사용자 입력을 쉼표를 기준으로 토큰화하여 문자열 리스트를 반환합니다.
     * @return 문자열 리스트
     * @throws IllegalArgumentException 입력 과정에서 예외가 발생한 경우
     */
    public static List<String> getCarNames() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        try {
            String input = Console.readLine();
            return Arrays.stream(input.split(",")).toList();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * 사용자에게 라운드 수를 입력할 것을 요구합니다.
     * @return 입력한 정수
     * @throws IllegalArgumentException 사용자 입력을 정수로 바꿀 수 없는 경우
     */
    public static int getTotalRound() throws IllegalArgumentException {
        System.out.println("시도할 회수는 몇회인가요?");

        try {
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * 주어진 경주의 현재 라운드 상황을 출력합니다.
     * @param race 경주
     */
    public static void printCurrentState(Race race) {
        System.out.println(race);
    }
}
