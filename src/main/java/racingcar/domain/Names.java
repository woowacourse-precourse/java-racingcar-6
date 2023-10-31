package racingcar.domain;

import racingcar.constant.ExceptionMessage;
import racingcar.constant.OutputMessage;

import java.util.*;

public class Names {

    private final List<Name> elements;


    public Names(List<Name> elements) {
        validateDuplicateName(elements);
        this.elements = new ArrayList<>(elements);
    }

    private void validateDuplicateName(List<Name> elements) {
        Set<Name> notDuplicateNames = new HashSet<>(elements);
        if (notDuplicateNames.size() != elements.size()) {
            ExceptionMessage exceptionMessage = ExceptionMessage.DUPLICATE_NAME;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(elements);
    }

    public String getElements() {
        List<String> names = elements.stream()
                .map(Name::toString)
                .toList();
        return String.join(OutputMessage.WINNER_DELIMITER.getMessage(), names);
    }
}
