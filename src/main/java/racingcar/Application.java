package racingcar;

public class Application {
    public static void main(String[] args) {
        RacingCarService racingCarService = new RacingCarService();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        racingCarService.getCars();

        System.out.println("시도할 횟수는 몇회인가요?");
        int move = racingCarService.getMove();
        System.out.println();

        System.out.println("실행 결과");
        for (int i = 0; i < move; i++) {
            racingCarService.move();
        }

        System.out.print("최종 우승자 : ");
        String result = racingCarService.getWinners();
        System.out.println(result);
    }
}
