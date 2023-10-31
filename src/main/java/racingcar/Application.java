package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.mockito.internal.matchers.Null;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 자동차들 입력받기
        String[] cars = makingCarList();

        // 실시횟수 입력받기
        int rounds = askRounds();

        // 레이싱 진행
        System.out.println("실행 결과");
        Integer[] progress = new Integer[cars.length];
        for(int i=0; i< cars.length; i++){
            progress[i] = 0;
        }
        for(int i=0; i<rounds; i++){
            for(int j=0; j<cars.length; j++){
                randomForward(cars, progress, j);
                printRacingStatus(j, progress, cars);
            }
            System.out.println(" ");
        }

        // 우승자 판독 출력
        whoisWinner(cars, progress);
    }

    private static void randomForward(String[] cars, Integer[] progress, int carindex){
        int randomnumber = Randoms.pickNumberInRange(0,9);
        if(randomnumber >= 4){
            progress[carindex] += 1;
        }
    }
    private static void whoisWinner(String[] cars, Integer[] progress){
        int maxPoint = 0;
        for(int i=0; i<cars.length; i++){
            maxPoint = Math.max(maxPoint, progress[i]);
        }
        ArrayList<String> winner = new ArrayList<String>();
        for(int j=0; j< progress.length; j++){
            if(progress[j] == maxPoint){
                winner.add(cars[j]);
            }
        }
        if(winner.size() == 1){
            System.out.println("최종 우승자 : " + winner.get(0));
        }
        else{
            String winnerString = winner.get(0);
            for(int i=1; i<winner.size(); i++){
                winnerString += ", " + winner.get(i);
            }
            System.out.println("최종 우승자 : " + winnerString);
        }

    }
    private static String[] makingCarList(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carname = Console.readLine();
        if(carname.equals("")){
            throw new IllegalArgumentException();
        }
        String[] cars = carname.split(",");
        if(cars.length < 1){
            throw new IllegalArgumentException();
        }
        for(int i=0; i<cars.length; i++){
            if(cars[i].length() > 5){
                throw new IllegalArgumentException();
            }
        }
        return cars;
    }
    private static void printRacingStatus(int carindex, Integer[] progress, String[] cars){
        String progressbar = "";
        for(int i=0; i<progress[carindex]; i++){
            progressbar += "-";
        }
        System.out.println(cars[carindex] + " : " + progressbar);
    }

    private static int askRounds(){
            System.out.println("시도할 횟수는 몇회인가요?");
            String input = Console.readLine();
            int rounds = Integer.parseInt(input);
            return rounds;
    }

}
