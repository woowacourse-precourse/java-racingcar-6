package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.utils.InputValidator.checkName;
import static racingcar.utils.InputValidator.checkRoundNum;

public class RacingGame {
    public static String[] inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return checkName(Console.readLine().split(","));
    }

    public static int inputRacingRound(){
        System.out.println("시도할 회수는 몇회인가요?");
        return checkRoundNum(Console.readLine());
    }

    public static int makeRandomNum(){
        return Randoms.pickNumberInRange(0,9);
    }

    public static boolean isForward(){
        return makeRandomNum() >= 4;
    }

    public static void racing(List<Car> carList){
        for (Car car: carList){
            if(isForward()) car.moveForward();
        }
    }

    public static void printCar(List<Car> carList){
        for(Car tempCar : carList){
            System.out.print(tempCar.getName() + " : " );
            drawDash(tempCar.getLocation());
            System.out.println();
        }
    }

    public static void drawDash(int num){
        for(int i = 0; i < num; i++){
            System.out.print("-");
        }
    }

    public static ArrayList<String> judgeWinner(List<Car> carList){
        int maxLocation = 0;
        ArrayList<String> tempWinnerList = new ArrayList<>();
        for(Car tempCar : carList){
            if(tempCar.getLocation() > maxLocation){
                tempWinnerList.clear();
                tempWinnerList.add(tempCar.getName());
                maxLocation = tempCar.getLocation();
            }
            else if (tempCar.getLocation() == maxLocation) {
                tempWinnerList.add(tempCar.getName());
            }
        }
        return tempWinnerList;
    }

    public static void printWinner(List<Car> carList){
        ArrayList<String> winner = judgeWinner(carList);
        System.out.print("최종 우승자 : ");

        System.out.print(winner.get(0));
        if(winner.size() > 1) {
            System.out.print(", ");
            for(int i = 1; i < winner.size(); i++) {
                System.out.print(winner.get(i));
            }
        }
    }

    public static void outputService(List<Car> carList, int racingNum){
        System.out.println("실행 결과");

        for(int i = 0; i < racingNum ; i++){
            racing(carList);
            printCar(carList);
            System.out.println();
        }

        printWinner(carList);
    }
}
