package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.MoveStatus;

public final class MoveStatuses {

    private static final String MOVE_EXPRESSION = "-";
    private final List<MoveStatus> elements;

    public MoveStatuses() {
        this.elements = new ArrayList<>();
    }

    public void add(final MoveStatus moveStatus) {
        elements.add(moveStatus);
    }

    public int numOfElement() {
        return elements.size();
    }

    public String toResultMessage() {
        return elements.stream()
                .map(element -> MOVE_EXPRESSION)
                .collect(Collectors.joining());
    }
}
