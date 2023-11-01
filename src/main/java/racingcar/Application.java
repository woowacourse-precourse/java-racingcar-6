package racingcar;

public class Application  {
    public static void main(String[] args) {
        RacingGameService gameService = new RacingGameService();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        gameService.inputCarNames();

        System.out.println("시도할 횟수는 몇회인가요?");
        int numberOfAttempts = gameService.getInputAttempts();
        System.out.println();

        System.out.println("실행 결과");
        for (int i = 0; i < numberOfAttempts; i++) {
            gameService.playRound();
        }

        System.out.print("최종 우승자 : ");
        String winners = gameService.getWinners();
        System.out.println(winners);
    }
}
