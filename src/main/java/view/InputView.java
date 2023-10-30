package view;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public List<String> carName() {
        String input = readLine();
        return List.of(input.split(","));
    }

    public int roundNumber() {
        String input = readLine();
        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }
    }
}
