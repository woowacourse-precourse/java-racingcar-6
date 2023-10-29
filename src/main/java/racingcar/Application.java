package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = Console.readLine();
        String[] carArray = carInput.split(",");
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = Integer.parseInt(Console.readLine());
        int[]raceAccumulations = new int[carArray.length];

    }

    private static int makeRandomNum(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum;
    }

    private static void printEachScore(int[] raceAccumulations){
        for (int index=0; index<raceAccumulations.length; index++){
            int substitutionNum = raceAccumulations[index];
            for (int printNum=0; printNum<substitutionNum; printNum++){
                System.out.println("-");
            }
        }
    }

    private static int[] playGame(int tryNumber, String[]carArray,int[] raceAccumulations){
        for (int i=0; i<tryNumber; i++){
            for (int changeScore=0; changeScore<carArray.length; changeScore++){
                raceAccumulations = giveScore(changeScore,raceAccumulations);
            }
        }
        return raceAccumulations;
    }

    private static int[] giveScore(int chanceScore,int[]raceAccumulations){
        int randomNum = makeRandomNum();
        if (randomNum>=4){
            raceAccumulations[chanceScore]+=1;
        }
        return raceAccumulations;
    }

    private static void printEachRace(int[] raceAccumulations, String[]carArray){
        for (int index=0; index<carArray.length; index++){
            System.out.print(carArray[index]+" : ");
            printEachScore(raceAccumulations);
        }
        System.out.println();
    }

    private static void findFinalWinner(int[]raceAccumulations, String[]carArray){
        int maxScore = 0;
        ArrayList<String>WinnerNames = new ArrayList<>();
        for (int index=0; index<carArray.length; index++){
            if (raceAccumulations[index]>maxScore){
                maxScore = raceAccumulations[index];
                WinnerNames.clear();
                WinnerNames.add(carArray[index]);
            }
            else if (raceAccumulations[index]==maxScore){
                WinnerNames.add(carArray[index]);
            }
        }
    }


}
