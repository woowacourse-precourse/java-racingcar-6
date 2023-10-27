package racingcar;

final class Output {

    private Output() {
    }

    static void printInputNames() {
        System.out.println(OutputMessage.INPUT_NAMES.message);
    }

    static void printInputCount() {
        System.out.println(OutputMessage.INPUT_COUNT.message);
    }

    static void printResult() {
        System.out.print(OutputMessage.RESULT.message);
    }

    static void printGameResult(final String result) {
        System.out.println(result);
        System.out.println();
    }

    //TODO String말고 Winner 객체로?
    static void printWinner(String winner) {
        System.out.println(OutputMessage.WINNER.message + winner);
    }
}
