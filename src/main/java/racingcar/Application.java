package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 리팩토링
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        String inputStr = readLine();
        int attemptNumber = Integer.parseInt(inputStr);
        System.out.println();
        System.out.println("실행 결과");
        User user = new User();
        user.makeCars(inputCarNames);
        user.tryDriving(attemptNumber);
        GameManager gameManager = new GameManager(user);
        System.out.println("최종 우승자" + " : " + gameManager.announceWinner());
    }
}
