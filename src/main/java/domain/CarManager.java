package domain;

import java.util.List;

public class CarManager {
    private static final int STANDARD_FOR_GO = 4;

    boolean decideGo(int condition) {
        return condition >= STANDARD_FOR_GO;
    }
}
