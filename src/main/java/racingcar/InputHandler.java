package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public List<String> getCarNames() {
        String userInput = Console.readLine();

        String[] parts = userInput.split(",");
        List<String> result = new ArrayList<>();

        for (String part : parts) {
            //공백제거 후 리스트에 추가
            result.add(part.trim());
        }

        return result;
    }

    public int getNumberOfRound() {
        String userInput = Console.readLine();
        int result = Integer.parseInt(userInput);

        return result;
    }
}
