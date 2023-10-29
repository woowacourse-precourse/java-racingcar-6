package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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

    // 파라미터의 random은 외부에서 랜덤 값을 생성하여 집어넣어주는 방식으로 구현 필요
    public boolean go(int random){
        if (random >= 4) {
            return false;
        }
        return true;
    }
}
