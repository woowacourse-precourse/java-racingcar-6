package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {

    public static void main(String[] args) {
        inputCarNames();
        inputTryCount();
        printRaceProgress();
        printWinner();
    }

    private static String[] inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        return inputCarNames.split(",");
    }

    private static int NumberOfInputCars(String[] inputCarNames){
        return inputCarNames.length;
    }

    private static Integer[] allCarsMoveScore(int NumberOfInputCars){
        return new Integer[NumberOfInputCars];
    }

    private static int inputTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private static int CarMoveForward(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber >=4){
            return 1;
        }else{
            return 0;
        }
    }


    private static Integer[] raceOnce(){
        String[] inputCarNames = inputCarNames();
        Integer[] allCarsMoveScore = allCarsMoveScore(NumberOfInputCars(inputCarNames()));
        for(int i=0;i<NumberOfInputCars(inputCarNames);i++){
            System.out.print(inputCarNames[i]);
            System.out.print(" : ");
            allCarsMoveScore[i] = CarMoveForward();
            for(int j=0;j<allCarsMoveScore[i];j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        return allCarsMoveScore;
    }


    private static void printRaceProgress(){
        System.out.println("\n실행 결과");
        for (int i=0;i<inputTryCount();i++){
            raceOnce();
        }
    }

    private static void findWinner() {
        Integer[] raceOnce = raceOnce();
        String[] inputCarNames= inputCarNames();
        int NumberOfInputCars = NumberOfInputCars(inputCarNames());
        int maxValue = raceOnce[0];
        List<Integer> IndicesOfWinnerCars = new ArrayList<>();

        for (int i = 0; i < NumberOfInputCars; i++) {
            if(raceOnce()[i]> maxValue){
                IndicesOfWinnerCars.clear();
                IndicesOfWinnerCars.add(i);
                maxValue=raceOnce[i];
            } else if(raceOnce[i] == maxValue){
                IndicesOfWinnerCars.add(i);
            }
        }

        int NumberOfWinner =IndicesOfWinnerCars.size();

        for(int j=0;j<NumberOfWinner;j++){
            if(j == NumberOfWinner-1) {
                System.out.print(inputCarNames[j]);
                break;
            }
            else {
                System.out.print(inputCarNames[j]);
                System.out.print(", ");
            }
        }


    }

    private static void printWinner(){
        System.out.print("최종 우승자 : ");
        findWinner();
    }




}
