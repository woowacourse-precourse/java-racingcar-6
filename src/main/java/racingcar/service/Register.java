package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.RacingGroup;

public class Register {
    private final String ASK_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private String namesInput;
    private List<String> names;
    private RacingGroup racingGroup;

    public Register() {
        this.racingGroup = new RacingGroup();
    }

    public RacingGroup set() {
        register();
        return racingGroup;
    }

    private void register() {
        printAskCarNamesMessage();
        getCarNames();
        addCarToRacing();
    }

    private void addCarToRacing() {
        for (String name : names) {
            validateNameLength(name);
            racingGroup.addCarToGroup(name);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private void getCarNames() {
        namesInput = getUserInput();
        validateComma();
        names = List.of(namesInput.split(","));
    }

    private String getUserInput() {
        return Console.readLine().trim();
    }

    private void validateComma() {
        if (!namesInput.contains(",")) {
            throw new IllegalArgumentException("차 이름은 쉼표(,)로 구분해주세요.");
        }
    }

    private void printAskCarNamesMessage() {
        System.out.println(ASK_CAR_NAMES_MESSAGE);
    }


}
