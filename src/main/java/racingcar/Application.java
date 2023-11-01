package racingcar;

import racingcar.Controller.RacingGameController;
import racingcar.View.RacingGameView;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input=sc.nextLine();
        String[] carNames=input.split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int game=sc.nextInt();

        RacingGameView view = new RacingGameView();
        RacingGameController controller = new RacingGameController(Arrays.asList(carNames),view );

        System.out.println("실행 결과");
        controller.startGame(game);

        sc.close();
    }
}
