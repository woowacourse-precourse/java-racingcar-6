package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {
    private static int count = 0;
    private static List<Car> carList = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String userInput = Console.readLine();
        String[] names = userInput.split(",");

        for(int i = 0; i < names.length; i++){
            addCar(names[i]);
        }

        try{
            System.out.println("시도할 회수는 몇회인가요?");
            count = Integer.parseInt(Console.readLine());

            if(count < 0){
                throw new IllegalArgumentException();
            }

        }catch (Exception e){
            throw new IllegalArgumentException();
        }

        printResult();
        findWinner();
    }

    public static void addCar(String name){
        Car tempCar = new Car(name.trim());
        carList.add(tempCar);
    }

    public static void printResult(){
        System.out.println("실행 결과");
        while(count-- > 0){
            for(int i = 0; i < carList.size(); i++){
                carList.get(i).moveOrStop();
                carList.get(i).printPosition();
            }
            System.out.println();
        }
    }

    public static void findWinner(){

        String result = "최종 우승자 : ";
        int maxValue = getMaxPosition();

        String WinnerNames = "";
        for(int i = 0; i < carList.size(); i++){
            if(carList.get(i).getPosition() == maxValue){
                WinnerNames = addComma(WinnerNames);
                WinnerNames += carList.get(i).getName();
            }
        }

        System.out.println(result + WinnerNames);
    }

    public static int getMaxPosition(){
        int maxValue = 0;
        for(int i = 0; i < carList.size(); i++){
            int pos = carList.get(i).getPosition();
            if(pos > maxValue){
                maxValue = pos;
            }
        }

        return maxValue;
    }

    public static String addComma(String result){
        if(!result.isEmpty()){
            result += ", ";
        }
        return result;
    }

}
