package racingcar.view.output;

public interface Outputview {

    void askCarNames();
    void askPlayCount();
    void printResult();
    void printEachCarStatus(final String name, final int position);
    void printBlankLine();
    void printWinners();
}
