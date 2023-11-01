package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        NameInput.getNameInput();
        NameInput.checkNameInput();
        List<Car> carArr = NameInput.setNameInput();

        String input = CountInput.getCountInput();
        CountInput.checkCountInput(input);

        MoveForward.totalGame(carArr, CountInput.getCount());

        SelectWinner.selectWinner(carArr);
        SelectWinner.printWinner();
    }
}
