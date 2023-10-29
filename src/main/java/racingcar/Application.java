package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Application application = new Application();
        String input = application.input_name();
        String[] split = application.devide_name(input);
        application.exceptionOfNameLength(split);

    }

    public String input_name(){
        String input = Console.readLine();
        return input;
    }

    public String[] devide_name(String input){
        String[] split = input.split(",");
        return split;
    }

    public void exceptionOfNameLength(String[] split){
        for (String s : split) {
            if (s.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
