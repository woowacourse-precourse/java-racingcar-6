package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Race race = receiveRaceInformation();
        race.raceAccumulations=playGame(race);
        ArrayList<String>WinnerNames = findFinalWinner(race);
        printFinalResult(WinnerNames);
    }
    private static Race receiveRaceInformation(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = Console.readLine();
        String[] carArray = carInput.split(",");
        checkNameError(carArray);
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = Integer.parseInt(Console.readLine());
        System.out.println();

        int[]raceAccumulations = new int[carArray.length];
        return new Race(carArray,tryNumber,raceAccumulations);
    }

    private static int makeRandomNum(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum;
    }

    private static void printEachCarScore(Race race,int index){
            int substitutionNum = race.raceAccumulations[index];
            for (int printNum=0; printNum<substitutionNum; printNum++){
                System.out.print("-");
            }
        }

    private static int[] playGame(Race race){
        System.out.println("실행 결과");
        for (int i=0; i<race.tryNumber; i++){
            for (int changeScore=0; changeScore<race.carArray.length; changeScore++){
                race.raceAccumulations = giveScore(changeScore,race);
            }
            printEachRace(race);
        }
        return race.raceAccumulations;
    }

    private static int[] giveScore(int chanceScore,Race race){
        int randomNum = makeRandomNum();
        if (randomNum>=4){
            race.raceAccumulations[chanceScore]+=1;
        }
        return race.raceAccumulations;
    }

    private static void printEachRace(Race race){
        for (int index=0; index<race.carArray.length; index++){
            System.out.print(race.carArray[index]+" : ");
            printEachCarScore(race,index);
            System.out.println();
        }
        System.out.println();
    }

    private static ArrayList<String> findFinalWinner(Race race){
        int maxScore = 0;
        ArrayList<String>WinnerNames = new ArrayList<>();
        for (int index=0; index<race.carArray.length; index++){
            if (race.raceAccumulations[index]>maxScore){
                maxScore = race.raceAccumulations[index];
                WinnerNames.clear();
                WinnerNames.add(race.carArray[index]);
            }
            else if (race.raceAccumulations[index]==maxScore){
                WinnerNames.add(race.carArray[index]);
            }
        }
        return WinnerNames;
    }
    private static void printFinalResult(ArrayList<String>WinnerNames){
        System.out.print("최종 우승자 :");
        for (int winnerName =0; winnerName<WinnerNames.size(); winnerName++){
            if (winnerName==0){
            System.out.print(" "+WinnerNames.get(winnerName));}

            else {
                System.out.print(", "+WinnerNames.get(winnerName));
            }
        }
    }

    private static void checkNameError(String[]carArray){
        for (String carName: carArray){
            if (carName.length()>5){
                throw new IllegalArgumentException("5자를 넘는 이름을 입력하셨습니다. 오류 발생");
            }
            if (carName.isEmpty()){
                throw new IllegalArgumentException("자동차 이름으로 공백 값을 입력하셨습니다. 오류 발생");
            }
        }
    }
}
