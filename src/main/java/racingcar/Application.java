package racingcar;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();

        // 사용자로부터 자동차 이름과 이동 횟수를 입력 받는 부분
        String carNames = console.readLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ");
        int tryCount = console.readInt("시도할 회수는 몇회인가요?: ");

        RacingGame racingGame = new RacingGame(carNames);
        racingGame.start(tryCount);

        console.println("실행 결과");
        racingGame.printRaceResults();

        console.println("최종 우승자: " + racingGame.getWinners());
    }
}


