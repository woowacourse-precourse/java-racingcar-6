package racingcar.game.io;

import java.util.List;
import racingcar.entity.Car;

public class RacingGameResponder {

    private static String START_GAME_PROCESS_INFORMING_LABEL = "실행 결과\n";
    private static String WINNER_INFORMING_LABEL = "최종 우승자 : ";

    private boolean isInformingGameProcess = false;

    public void informGameProcess(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        if (!isInformingGameProcess) {
            sb.append(START_GAME_PROCESS_INFORMING_LABEL);
        }
        cars.forEach(car -> appendCarPosition(sb, car));
        System.out.println(sb);
    }

    private void appendCarPosition(StringBuilder sb, Car car) {
        sb.append(car.getName())
                .append(" : ")
                .append("-".repeat(car.getPosition()))
                .append("\n");
    }

    public void informGameResult(List<String> names) {
        StringBuilder sb = new StringBuilder(WINNER_INFORMING_LABEL);
        sb.append(String.join(", ", names));
        System.out.println(sb);
    }

}
