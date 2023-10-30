package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 자동차들 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] cars = makingCarList(Console.readLine());
        // 실시횟수 입력받기
        System.out.println("시도할 회수는 몇회인가요?");
        int rounds = Integer.parseInt(Console.readLine());
        // 레이싱 진행
        System.out.println("실행 결과");
        Integer[] progress = new Integer[cars.length];
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

    public static void randomForward(String[] cars, Integer[] progress, int carindex){
        int randomnumber = Randoms.pickNumberInRange(0,9);
        if(randomnumber >= 4){
            progress[carindex] += 1;
        }
    }
    public static void whoisWinner(String[] cars, Integer[] progress){
        int maxPoint = 0;
        for(int i=0; i<cars.length; i++){
            maxPoint = Math.max(maxPoint, progress[i]);
        }
        String winners = "";
        for(int j=0; j< progress.length; j++){
            if(progress[j] == maxPoint){
                winners += (" " + cars[j]);
            }
        }
        System.out.println("최종 우승자 :" + winners);

    }
    public static String[] makingCarList(String userinput){
        String[] cars = userinput.split(",");
        return cars;
    }
    public static void printRacingStatus(int carindex, Integer[] progress, String[] cars){
        String progressbar = "";
        for(int i=0; i<progress[carindex]; i++){
            progressbar += "-";
        }
        System.out.println(cars[carindex] + " : " + progressbar);
    }

}
