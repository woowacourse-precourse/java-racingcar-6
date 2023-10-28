package racingcar.core.io;

import racingcar.core.NamesParser;

import java.util.List;

public class Validator {
    private final NamesParser namesParser;

    public Validator(final NamesParser namesParser) {
        this.namesParser = namesParser;
    }

    public void valid(String userInput) {
        List<String> parsingList = namesParser.parsing(userInput);
        for (String name : parsingList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
