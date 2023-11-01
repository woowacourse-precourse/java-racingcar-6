package racingcar.view;

import java.util.List;

public sealed interface ConsoleView permits IOView {
    void showSingleMessage(final String message);
    void showMessages(final List<String> message);
    void showHeadMessage(final String givenMessage);
    String readUserInput();

}
