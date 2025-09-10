package racingcar.view;

import java.util.List;

public record CarListRequest(
    List<String> carNames
) {

}
