package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class MoveHistory {
    private final List<CarGroup> carGroupHistory;

    private MoveHistory(List<CarGroup> carGroupHistory) {
        this.carGroupHistory = new ArrayList<>(carGroupHistory);
    }

    public static MoveHistory from(List<CarGroup> carGroupHistory) {
        return new MoveHistory(carGroupHistory);
    }
}
