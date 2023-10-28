package racingcar;

import camp.nextstep.edu.missionutils.Console;
import model.GameManager;

public class Application {
    private static String firstMent = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println(firstMent);

        //이름 입력
        String nameInput = Console.readLine();

        String[] carName = nameInput.split(",");

        int num = Integer.parseInt(Console.readLine());

        new GameManager(carName, num);

    }
}
