package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Setting;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Setting setting = new Setting();
        Printer printer = new Printer();

        printer.requestNames();
        setting.setNames(Console.readLine());
        printer.requestTrial();
        setting.setTrial(Console.readLine());
    }
}
