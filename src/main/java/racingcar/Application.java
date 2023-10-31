package racingcar;

import racingcar.domain.Position;
import racingcar.domain.Race;

import java.util.List;

import static racingcar.domain.Position.updatePositions;
import static racingcar.domain.Race.createRaceFromInput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Race race = createRaceFromInput();
        List<Position> positions = updatePositions(race);
        String winners = getWinners(positions, race.tryValue());
        System.out.print("최종 우승자 : " + winners);

    }

    private static String getWinners(List<Position> positions, int tryCnt) {
        StringBuilder winners = new StringBuilder();
        for (Position position : positions) {
            if (position.distanceValue() == tryCnt) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(position.carInfo());
            }
        }
        return winners.toString();
    }
}
