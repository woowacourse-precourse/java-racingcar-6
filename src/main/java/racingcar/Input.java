package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;


public class Input {

    ArrayList<String> carNameArrayList;

    Input(){
        this.carNameArrayList = splitInputCarName(inputCarName());
    }



    public String inputCarName() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");

        return Console.readLine();
    }

    public ArrayList<String> splitInputCarName(String input){
        String[] inputArray = input.split(","); //문자열->문자열 배열
        ArrayList<String> inputArrayList = new ArrayList<>(Arrays.asList(inputArray)); //문자열 배열->ArrayList

        return inputArrayList;
    }


    public static int inputMoveNumber() {
        System.out.print("시도할 회수는 몇회인가요?\n");



        return Integer.parseInt(Console.readLine());
    }
}
