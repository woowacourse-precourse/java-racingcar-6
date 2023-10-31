package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class RacingGameInputView {
    private static void checkCarNames(List<String> inputNames){
        for(String name: inputNames) {
            if(name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static int checkTurn(String turnInput){
        try {
            return Integer.parseInt(turnInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public String nameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputs = Console.readLine();
        return inputs;
    }

    public String turnsInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return input;
    }
}
