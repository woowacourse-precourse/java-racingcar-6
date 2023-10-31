package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Cars;

/**
 * 경기의 결과를 출력하는 Output View
 */
public class OutputView {
    static private String STRING_START_GAME = "실행 결과";
    static private String STRING_RESULT = "최종 우승자 : ";

    /**
     * 게임시작한다는 문구 출력
     */
    public void printStartGame() {
        System.out.println();
        System.out.println(STRING_START_GAME);
    }

    /**
     * 현재 회차의 각 자동차의 이름과 이동거리 출력
     *
     * @param cars car들이 모여있는 cars
     */
    public void printCurrentGame(Cars cars) {
        StringBuilder sb = new StringBuilder();
        cars.getCars().stream().forEach(car -> {
            sb.append(car.getName());
            sb.append(" : ");
            sb.append("-".repeat(car.getDistance()));
            sb.append("\n");
        });
        System.out.println(sb);
    }

    /**
     * 게임의 결과를 출력하는 메서드
     *
     * @param winners 이동거리가 최대인 자동차들의 이름
     */
    public void printResult(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(STRING_RESULT);
        if (winners.size() == 1) {
            sb.append(winners.get(0));
        }
        if (winners.size() > 1) {
            sb.append(winners.stream().collect(Collectors.joining(", ")));
        }
        System.out.println(sb);
    }
}
