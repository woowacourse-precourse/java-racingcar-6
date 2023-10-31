package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarInputProcess;
import racingcar.domain.RacingRecord;
import racingcar.domain.RacingResult;
import racingcar.domain.RepeatInputProcess;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        List<String> cars = carsInput();
        int repeat = repeatInput();

        racingGame(cars, repeat);
    }

    private static List<String> carsInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        CarInputProcess carInputProcess = new CarInputProcess();
        String input = Console.readLine();
        List<String> cars = carInputProcess.process(input);

        return cars;
    }

    private static int repeatInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        RepeatInputProcess repeatInputProcess = new RepeatInputProcess();
        String input = Console.readLine();
        int repeat = repeatInputProcess.process(input);
        return repeat;
    }

    private static void racingGame(List<String> cars, int repeat) {
        System.out.println("\n실행 결과");

        RacingRecord racingRecord = new RacingRecord();
        Map<String, Integer> records = racingRecord.initRecord(cars);

        while(repeat-- > 0) {
            records = racingRecord.record(cars, records);
            String print = racingRecord.printRacingRecord(cars, records);
            System.out.println(print);
        }

        racingResult(records);
    }

    private static void racingResult(Map<String, Integer> records) {
        RacingResult racingResult = new RacingResult();
        int maximumDistance = racingResult.findMaximumDistance(records);
        List<String> winners = racingResult.findWinners(maximumDistance, records);

        printResult(winners);
    }

    private static void printResult(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for(int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i));
            if(i != winners.size() - 1) {
                sb.append(winners.get(i)).append(",");
            }
        }

        System.out.println(sb);
    }
}
