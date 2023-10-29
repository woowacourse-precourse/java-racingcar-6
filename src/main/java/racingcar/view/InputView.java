package racingcar.view;

import java.util.List;

public interface InputView {
    List<String> enterCarNames();

    String getDelimiterDescription();

    String getDelimiter();

    int enterTryCount();
}
