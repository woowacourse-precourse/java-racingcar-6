package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String rawCarNames = Console.readLine();
        String[] participants = InputValidation.validateInputNames(rawCarNames);

        System.out.println("시도할 회수는 몇회인가요?");
        String rawMoveCount = Console.readLine();
        int totalMoves = InputValidation.validateInputMoveCount(rawMoveCount);

        RacingGame game = new RacingGame(totalMoves);
        for (String participantName : participants) {
            game.addParticipant(new Car(participantName));
        }
        game.proceed();
        System.out.println(game.getResult());
    }
}
