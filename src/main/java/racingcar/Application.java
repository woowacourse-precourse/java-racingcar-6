package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = Console.readLine();
        String[] carArray = carInput.split(",");
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = Integer.parseInt(Console.readLine());
        int[]raceAccumulation = new int[carArray.length];

    }

    private static int makeRandomNum(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum;
    }

    private static void printEachScore(int[] raceAccumulation){
        for (int index=0; index<raceAccumulation.length; index++){
            int substitutionNum = raceAccumulation[index];
            for (int printNum=0; printNum<substitutionNum; printNum++){
                System.out.println("-");
            }
        }
    }

    private static int[] playGame(int tryNumber, String[]carArray,int[] raceAccumulation){
        for (int i=0; i<tryNumber; i++){
            for (int changeScore=0; changeScore<carArray.length; changeScore++){
                raceAccumulation = giveScore(changeScore,raceAccumulation);
            }
        }
        return raceAccumulation;
    }

    private static int[] giveScore(int chanceScore,int[]raceAccumulation){
        int randomNum = makeRandomNum();
        if (randomNum>=4){
            raceAccumulation[chanceScore]+=1;
        }
        return raceAccumulation;
    }

    private static void printEachRace(int[] raceAccumulation, String[]carArray){
        for (int index=0; index<carArray.length; index++){
            System.out.print(carArray[index]+" : ");
            printEachScore(raceAccumulation);
        }
        System.out.println();
    }

}
