package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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
        int[] progress = new int[cars.length];
        for(int i=0; i<rounds; i++){
            for(int j=0; j<cars.length; j++){
                randomForward(cars, progress, j);
                printRacingStatus(j, progress, cars);
            }
            System.out.println(" ");
        }
        // 우승자 판독 출력
    }
    public static void randomForward(String[] cars, int[] progress, int carindex){
        int randomnumber = Randoms.pickNumberInRange(0,9);
        if(randomnumber >= 4){
            progress[carindex] += 1;
        }
    }
    public static void whoisWinner(String[] cars, int[] progress){

    }
    public static String[] makingCarList(String userinput){
        String[] cars = userinput.split(",");
        return cars;
    }
    public static void printRacingStatus(int carindex, int[] progress, String[] cars){
        String progressbar = "";
        for(int i=0; i<progress[carindex]; i++){
            progressbar += "-";
        }
        System.out.println(cars[carindex] + " : " + progressbar);
    }

}
