package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Input {
    ArrayList<String> carNameArrayList;

    Input(){
        this.carNameArrayList = splitInputCarName(inputCarName());
    }

    public String inputCarName() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String input = Console.readLine();
        checkInputCarNameContainComma(input);
        return input;
    }

    public ArrayList<String> splitInputCarName(String input){
        String[] inputArray = input.split(","); //문자열->문자열 배열
        ArrayList<String> inputArrayList = new ArrayList<>(Arrays.asList(inputArray)); //문자열 배열->ArrayList

        checkInputCarNameLength(inputArrayList);
        checkInputCarNameDuplication(inputArrayList);

        return inputArrayList;
    }

    public static int inputMoveNumber() {
        System.out.print("시도할 회수는 몇회인가요?\n");
        String moveNumber = Console.readLine();
        checkInputMoveNumber(moveNumber);
        return Integer.parseInt(moveNumber);
    }


    public void checkInputCarNameLength(ArrayList<String> carNameArray){
        for (String carName : carNameArray){
            if(carName.length() >= 1 && carName.length() > 5){
                throw new IllegalArgumentException("자동차 이름 글자수 오류");
            }
        }
    }

    public void checkInputCarNameDuplication(ArrayList<String> carNameArray){
        Set<String> set = new HashSet<>(); //HashSet은 중복을 허용하지 않는 것을 이용
        for (String item : carNameArray){
            if (!set.add(item)){ //HashSet에 add하려는 값이 이미 있으면 false 반환
                throw new IllegalArgumentException("자동차 이름 중복 오류");
            }
        }
    }

    public void checkInputCarNameContainComma(String input){
        if (!input.contains(",")) {
            throw new IllegalArgumentException("자동차 이름 문자열 , 포함 안함 오류");
        }
    }

    public static void checkInputMoveNumber(String moveNumber){
        for (char ch: moveNumber.toCharArray()) {
            if (Character.isDigit(ch) == false) {
                throw new IllegalArgumentException("이동 횟수 오류");
            }
        }
    }
}
