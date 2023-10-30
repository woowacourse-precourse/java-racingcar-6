package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = readLine();
        game.addCar(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        String trialString = readLine();
        int trials = Integer.parseInt(trialString);

        System.out.println("실행 결과");
        while(0<trials--){
            String move = game.move();
            System.out.println(move);
        }
        System.out.print("최종 우승자 : ");
        System.out.println(game.end());
    }
}
