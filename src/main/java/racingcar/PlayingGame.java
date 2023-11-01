package racingcar;
import java.util.ArrayList;
import java.util.List;

public class PlayingGame {
    public List<String> getCarName(String names) {
        List<String> carNames = new ArrayList<>();
        String[] splittedNames = separateCarName(names);

        for(String name : splittedNames) {
            carNames.add(name.trim());
        }
        return carNames;
    }
    public String[] separateCarName(String names) {
        return names.split(",");
        }
}
