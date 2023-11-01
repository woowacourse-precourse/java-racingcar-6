package racingcar;
import java.util.ArrayList;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Console;

public class Start {
    public ArrayList<String> name() {
        System.out.println("경주할 자동차 이름을 입력하세요,(이름은 쉼표(,)기준으로 구분)");
        String[] raw = Console.readLine().split(",");
        ArrayList<String> names = new ArrayList<>(Arrays.asList(raw));
        return names;
    }
}
