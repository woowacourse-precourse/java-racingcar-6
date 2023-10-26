package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    final static int CHARACTERS_LIMIT = 5;
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        // 기능 1.
        List<String> cars = Arrays.stream(Console.readLine().split(",")).toList();
        boolean anyNameExceedsCharactersLimit = cars.stream().anyMatch(car->car.length() > CHARACTERS_LIMIT);
        if(anyNameExceedsCharactersLimit) {
            throw new IllegalArgumentException(String.format("이름은 %d자를 넘지 못합니다.", CHARACTERS_LIMIT));
        }
        // 기능 2.
        System.out.println("시도할 회수는 몇회인가요?");
        int trial;
        try {
            trial = Integer.parseInt(Console.readLine());
            if(trial < 0){
                throw new IllegalArgumentException(String.format("게임 시도 횟수는 음수가 되면 안됩니다. 현재 작성한 횟수: %d", trial));
            }
            if(trial > Integer.MAX_VALUE ){
                throw new IllegalArgumentException("최고 횟수 초과");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }

        // 기능 3.
        // car마다 전진 조건 할당
        int[] scores = new int[cars.size()];

        for(int i=0; i<trial; i++){
            for(int j = 0; j<cars.size(); j++){
                boolean canMove = Randoms.pickNumberInRange(0,9) >= 4;
                if(canMove){
                    scores[j]++;
                }
                printScores(cars.get(j), scores[j]);

            }
            System.out.println(" ");
        }

        // 기능 5.
        int max = Arrays.stream(scores).max().getAsInt();
        List<String> winners = new ArrayList<>();
        for(int i = 0; i<scores.length; i++){
            if(scores[i] == max){
                winners.add(cars.get(i));
            }
        }
        printWinner(winners);


    }
    // 기능 4.
    public static void printScores(String name, int score){

        String scoreToPrint = "-".repeat(score);
        System.out.println(String.format("%s: %s", name, scoreToPrint));

    }

    // 기능 5.
    public static void printWinner(List<String> winners){
        System.out.printf("최종 우승자: ");
        System.out.println(String.join(",", winners));
    }
}
