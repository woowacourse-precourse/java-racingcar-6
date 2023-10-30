package racingcar.domain.game;

import java.util.Collections;
import java.util.List;

public record ResultDTO(List<String> logs, List<String> winners) {

    @Override
    public List<String> logs() {
        return Collections.unmodifiableList(logs);
    }

    @Override
    public List<String> winners() {
        return Collections.unmodifiableList(winners);
    }
}
