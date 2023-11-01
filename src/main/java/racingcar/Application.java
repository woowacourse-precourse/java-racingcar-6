package racingcar;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static List<String> carNames = new ArrayList<>();
    static List<Integer> carProgress = new ArrayList<>();
    static int bestScore = 0;

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        System.out.println("시도할 회수는 몇회인가요?");
        int gameCnt = Integer.parseInt(Console.readLine());

        String[] carNameArray  = input.split(",");


        for (String name : carNameArray) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
            carNames.add(name);
        }


        for (int i=0; i<carNames.size(); i++){
            carProgress.add(0);
        }

        System.out.println();
        System.out.println("실행 결과");

        while(gameCnt > 0){
            race();
            gameCnt--;
        }

        List<String> winner = new ArrayList<>();
        for (int i=0; i<carNames.size(); i++){
            if (carProgress.get(i) == bestScore){
                winner.add(carNames.get(i));
            }
        }
        String winners = String.join(", ", winner);
        System.out.print("최종 우승자 : " + winners);
    }

    protected static void race(){
        for (int i=0; i<carNames.size(); i++){
            int randomNum = Randoms.pickNumberInRange(0,9);
            if (randomNum >= 4) {
                carProgress.set(i, carProgress.get(i) + 1);
                bestScore = updateBestScore(carProgress.get(i), bestScore);
            }
            System.out.println(carNames.get(i)+" : "+ "-".repeat(carProgress.get(i)));
        }
        System.out.println();
    }

    protected static Integer updateBestScore(Integer carProgress, Integer bestScore){
        if (bestScore < carProgress) return carProgress;
        return bestScore;
    }
}
