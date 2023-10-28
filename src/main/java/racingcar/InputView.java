package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    public static List<Car> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");  // todo 같은 이름 입력하면?

    public static List<Car> getCars() {
        ResultView.printEnterNameGuide();
        return CarFactory.createCarsFromInput(Console.readLine());
    }

    public static int getRacingRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
