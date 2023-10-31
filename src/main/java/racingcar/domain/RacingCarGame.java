package racingcar.domain;

import static racingcar.domain.Calculator.countChar;
import static racingcar.domain.Calculator.generateRandomDash;
import static racingcar.domain.Calculator.winnerDashCount;
import static racingcar.view.View.displayResult;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.Car;
import racingcar.model.GameResult;
import racingcar.model.InputData;

public class RacingCarGame {
    private static List<StringBuilder> skeleton;
    private static final int FORWARD_THRESHOLD = 4;

    public static void playRace(InputData inputData, Car car) {
        int raceCount = Integer.parseInt(inputData.getAttemptCount());
        skeleton = createStringBuilders(car.getCarName());

        for (int i = 0; i < raceCount; i++) {
            goOrStop(skeleton);
            displayResult(skeleton);
            System.out.println();
        }
    }

    private static List<StringBuilder> createStringBuilders(List<String> carNameList) {
        List<StringBuilder> result = new ArrayList<>();

        for (String s : carNameList) {
            StringBuilder sb = new StringBuilder();
            sb.append(s).append(" : ");
            result.add(sb);
        }

        return result;
    }

    private static void goOrStop(List<StringBuilder> skeleton) {
        for (StringBuilder sb : skeleton) {
            sb.append(generateRandomDash());
        }
    }

    public static boolean makeMoveDecision() {
        int moveDecision = Randoms.pickNumberInRange(0, 9);

        return moveDecision >= FORWARD_THRESHOLD;
    }

    public static List<String> getGameWinner() {
        GameResult gameResult = new GameResult(skeleton);
        int winnerDashCount = winnerDashCount(gameResult);

        return gameResult.gameResultList().stream()
                .filter(stringBuilder -> countChar(stringBuilder.toString(), '-') == winnerDashCount)
                .map(carInfo -> carInfo.substring(0, carInfo.indexOf(" ")))
                .collect(Collectors.toList());
    }
}
