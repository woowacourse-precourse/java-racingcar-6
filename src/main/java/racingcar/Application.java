package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Race;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameString = Console.readLine();

        Race race = new Race();
        Map<String, String> carMap = race.saveCarMap(carNameString); // 입력받은 car 이름을 Map에 저장한다.

        System.out.println("시도할 회수는 몇회인가요?");
        String raceCount = Console.readLine();

        // 레이스 진행
        System.out.println();
        System.out.println("실행 결과");
        List<String> winnerCarNameList = race.raceGameStart(carMap, raceCount);

        // 최종 우승자 출력
        String commaWinnerCarName = String.join(",", winnerCarNameList);
        System.out.println("최종 우승자 : " + commaWinnerCarName);
    }
}
