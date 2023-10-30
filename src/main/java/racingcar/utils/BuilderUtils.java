package racingcar.utils;

import java.util.List;

public class BuilderUtils {
    private final StringBuilder[] builder;

    public BuilderUtils(List<String> carsName) {
        builder = new StringBuilder[carsName.size()];
        for (int i = 0; i < carsName.size(); i++) {
            builder[i] = new StringBuilder(carsName.get(i)).append(" : ");
        }
    }

    public void appendToCarPosition(int carIndex) {
        builder[carIndex].append("-");
    }

    public String[] getCarPositions() {
        String[] carPositions = new String[builder.length];
        for (int i = 0; i < builder.length; i++) {
            carPositions[i] = builder[i].toString();
        }
        return carPositions;
    }
}
