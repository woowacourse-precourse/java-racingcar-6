package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Race race = createRaceFromInput();
        System.out.println("\n실행 결과");
        List<Position> positions = updatePositions(race);
        String winners = getWinners(positions, race.tryValue());
        System.out.println("최종 우승자 : " + winners);

    }

    private static Race createRaceFromInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCountInput = Console.readLine();

        String[] carNames = InputCarValidator.carsByStringToArray(carInput);
        Set<String> uniqueCarNames = InputCarValidator.checkDuplicateCarName(carNames);
        List<Position> positions = createPositions(uniqueCarNames);
        TryCnt tryCnt = TryCnt.createTryCnt(tryCountInput);
        return Race.createRace(positions, tryCnt);
    }

    private static List<Position> createPositions(Set<String> carNames) {
        List<Position> positions = new ArrayList<>();
        for (String carName : carNames) {
            Car car = Car.createCar(carName);
            Position position = Position.createPosition(car);
            positions.add(position);
        }
        return positions;
    }

    private static List<Position> updatePositions(Race race) {
        while (race.positionList().get(0).distanceValue() < race.tryValue()
                && race.positionList().get(1).distanceValue() < race.tryValue()) {
            for (Position position : race.positionList()) {
                int randomDistance = Randoms.pickNumberInRange(0, 9);
                position.move(randomDistance);
                System.out.println(position.positionValue());
            }
            System.out.println();
        }
        return race.positionList();
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
