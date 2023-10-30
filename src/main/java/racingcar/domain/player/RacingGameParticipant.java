package racingcar.domain.player;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.RacingCar;
import racingcar.util.GameConsole;
import racingcar.util.PatternUtil;

public class RacingGameParticipant implements RacingPlayer {
        private final GameConsole gameConsole;

        public RacingGameParticipant(GameConsole console) {
                this.gameConsole = console;
        }

        @Override
        public List<Car> submitRacingCarList(int nameLength) {
                gameConsole.printlnMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                List<String> carNameList = Arrays.stream(gameConsole.readInput().split(",")).toList();

                carListValidation(carNameList, nameLength);
                return carNameList.stream().map(RacingCar::new).collect(Collectors.toList());
        }

        private void carListValidation(List<String> carList, int nameLength) {
                carList.forEach(car -> {
                        if (car.strip().length() == 0 || car.length() > nameLength) {
                                throw new IllegalArgumentException("자동차의 이름은 5자 이하의 문자만 가능합니다.");
                        }
                });
        }

        @Override
        public BigInteger submitLaps() {
                gameConsole.printlnMessage("시도할 회수는 몇회인가요?");
                String input = gameConsole.readInput();

                lapsValidation(input);

                BigInteger laps;
                try {
                        laps = new BigInteger(input);
                } catch (NumberFormatException e) {
                        throw new NumberFormatException("너무 큰 숫자입니다");
                }

                return laps;
        }

        private void lapsValidation(String input) {
                if (!input.matches(PatternUtil.getOnlyDigitNumberPattern())) {
                        throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
                }
        }
}
