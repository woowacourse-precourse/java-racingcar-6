package racingcar.domain;

import java.util.List;
import java.util.OptionalLong;
import racingcar.model.GameResult;

public class Calculator {
    static long countChar(String carInfo, char c) {
        return carInfo.chars()
                .filter(ch -> ch == c)
                .count();
    }

    public static int winnerDashCount(GameResult gameResult) {
        List<StringBuilder> gameResultList = gameResult.gameResultList();

        OptionalLong maxDashCount = gameResultList.stream()
                .mapToLong(stringBuilder -> countChar(stringBuilder.toString(), '-'))
                .max();

        return (int) maxDashCount.orElse(0);
    }

    public static String generateRandomDash() {
        String dash = "";

        if (RacingCarGame.makeMoveDecision()) {
            dash = "-";
        }

        return dash;
    }
}
