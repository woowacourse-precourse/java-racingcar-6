package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public String input_name(){
        String input = Console.readLine();
        return input;
    }

    public String[] devide_name(String input){
        String[] split = input.split(",");
        return split;
    }



}
