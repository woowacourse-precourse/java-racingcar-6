package view.outputView;

import java.util.List;

public interface OutputView {
    void printInsertCarNamesMessage();
    void printInsertAttemptMessage();

    void printResultMessage();
    void printResults(List<String> results);
    void printWinners(List<String> winners);
}
