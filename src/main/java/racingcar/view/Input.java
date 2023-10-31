package racingcar.view;

public class Input {
    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println(input);
        return input;
    }

    public static String inputRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println(input);
        return input;
    }
}
