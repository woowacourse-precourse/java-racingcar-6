package racingcar.domain.player;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import racingcar.util.GameConsole;
import racingcar.util.PatternUtil;

public class RacingGameParticipant implements RacingPlayer {
        private final GameConsole gameConsole;

        public RacingGameParticipant(GameConsole console) {
                this.gameConsole = console;
        }

        @Override
        public List<String> submitRacingCarNameList(final int nameLength) {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                List<String> carNameList = Arrays.stream(gameConsole.readInput().split(",")).toList();

                carListValidation(carNameList, nameLength);
                return carNameList;
        }

        private void carListValidation(final List<String> carList, final int nameLength) {
                carList.forEach(car -> {
                        if (car.strip().length() == 0 || car.length() > nameLength) {
                                throw new IllegalArgumentException("자동차의 이름은 5자 이하의 문자만 가능합니다.");
                        }
                });
        }

        @Override
        public BigInteger submitLaps() {
                System.out.println("시도할 회수는 몇회인가요?");
                String input = gameConsole.readInput();
                lapsValidation(input);

                return new BigInteger(input);
        }

        private void lapsValidation(final String input) {
                if (!input.matches(PatternUtil.ONLY_POSITIVE_NUMBER_PATTERN)) {
                        throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
                }
        }
}
