package racingcar.events.racingcargame;


import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Exception {


    public void inputNameException(String[] cars){
        for(int i=0; i<cars.length; i++){
            // 이름의 길이가 5를 넘는지 확인
            isInputNameMoreThan5(cars[i].length() > 5);

            // 이름에 공백이 들어가는지 확인
            isInputNameBlank(cars[i].contains(" "));

        }
    }

    private static void isInputNameBlank(boolean cars) {
        // 이름에 공백이 들어가는지 확인
        if (cars) {
            throw new IllegalArgumentException();
        }
    }

    private static void isInputNameMoreThan5(boolean cars) {
        // 이름의 길이가 5를 넘는지 확인
        if (cars) {
            throw new IllegalArgumentException();
        }
    }

    public void inputNameSameException(String[] cars){
        Set<String> sameName = new HashSet<>();
        // 중복 이름이 들어가는지 확인
        for (String car : cars) {
            inputNameSameCheckException(car, sameName);
        }
    }

    private static void inputNameSameCheckException(String car, Set<String> sameName) {
        // 중복 이름이 들어가는지 확인
        if (!sameName.add(car)) {
            throw new IllegalArgumentException();
        }
    }


    public String inputTryException(String chk){
        chk = readLine();
        for(int i=0; i<chk.length(); i++){
            // 시도횟수가 숫자로 바뀌는지 확인
            isInputTryDigit(!Character.isDigit(chk.charAt(i)));
        }
        return chk;
    }

    private static void isInputTryDigit(boolean chk) {
        // 시도횟수가 숫자로 바뀌는지 확인
        if (chk) {
            throw new IllegalArgumentException();
        }
    }

    public void isTryNumberPositive(int tries){
        if(tries < 0){
            throw new IllegalArgumentException();
        }
    }



}
