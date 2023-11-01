package racingcar.controller;

import static racingcar.model.InputToName.Separator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

import racingcar.model.Car;
import racingcar.model.InputToName;
import racingcar.model.NameToClass;

// cars 입력 & 저장
public class CarListController {

    final InputToName nameList;
    final NameToClass classList;

    public CarListController() {

        String input = Console.readLine();
        validateInput(input);

        nameList = new InputToName(input);

        classList = new NameToClass(nameList.getNameList());

    }

    private void validateInput(String input) {
        if (input.isBlank() ||
            input.startsWith(Separator) ||
            input.endsWith(Separator) ||
            input.contains(" ")) {

            throw new IllegalArgumentException("비정상적인 입력");

        }

    }

    public ArrayList<Car> getClassList() {
        return classList.getClassList();
    }

}

