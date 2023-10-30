package racingcar.fake;

import racingcar.util.GameConsole;

public class FakeGameConsoleUtil implements GameConsole {
        private final String inputText;

        public FakeGameConsoleUtil(String inputText) {
                this.inputText = inputText;
        }

        @Override
        public String readInput() {
                return inputText;
        }
}
