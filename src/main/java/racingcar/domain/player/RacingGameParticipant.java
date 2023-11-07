package racingcar.domain.player;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import racingcar.util.GameConsole;
import racingcar.util.PatternUtil;

/**
 * 경주 게임에 참여하는 플레이어의 개념 객체를 나타내는 클래스입니다.
 */
public class RacingGameParticipant implements RacingPlayer {
        /**
         * 콘솔에 입력을 받기 위한 유틸 클래스입니다.
         */
        private final GameConsole gameConsole;

        /**
         * 플레이어의 생성자로 GameConsole 유틸 클래스를 주입 받습니다.
         *
         * @param console 유틸 클래스
         */
        public RacingGameParticipant(GameConsole console) {
                if (console == null) {
                        throw new IllegalArgumentException("Null은 허용되지 않습니다.");
                }

                this.gameConsole = console;
        }

        /**
         * 플레이어가 입력한 자동차 경주에 참여할 자동차의 이름을 반환한다.
         *
         * @param nameLength 자동차 이름 제한 길이
         * @return 자동차 이름 리스트
         */
        @Override
        public List<String> submitRacingCarNameList(final int nameLength) {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                List<String> carNameList = Arrays.stream(gameConsole.readInput().split(",")).toList();

                carListValidation(carNameList, nameLength);
                return carNameList;
        }

        /**
         * 플레이어가 입력한 자동차의 이름의 유효성 검사를 실시한다.
         *
         * @param carNameList 자동차 이름 리스트
         * @param nameLength  자동차 이름 제한 길이
         * @throws IllegalArgumentException - 자동차의 이름이 제한 길이를 넘어가는 경우
         */
        private void carListValidation(final List<String> carNameList, final int nameLength) {
                carNameList.forEach(car -> {
                        if (car.strip().length() == 0 || car.length() > nameLength) {
                                throw new IllegalArgumentException("자동차의 이름은 5자 이하의 문자만 가능합니다.");
                        }
                });
        }

        /**
         * 플레이어가 입력한 laps 를 반환한다.
         *
         * @return laps
         */
        @Override
        public BigInteger submitLaps() {
                System.out.println("시도할 회수는 몇회인가요?");
                String input = gameConsole.readInput();
                lapsValidation(input);

                return new BigInteger(input);
        }

        /**
         * 플레이어가 입력한 laps 의 유효성 검사를 실시한다.
         *
         * @param input laps
         * @throws IllegalArgumentException - 양수를 제외한 입력의 경우
         */
        private void lapsValidation(final String input) {
                if (!input.matches(PatternUtil.ONLY_POSITIVE_NUMBER_PATTERN)) {
                        throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
                }
        }
}
