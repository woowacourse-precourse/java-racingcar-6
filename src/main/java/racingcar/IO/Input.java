package racingcar.IO;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    ManageException manageException = new ManageException();
    public String[] getName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String[] names = readLine().split(",");
        manageException.nameCount(names);

        return names;
    }

    public int getTimes() {
        System.out.println("시도할 회수는 몇회인가요?");

        String given = readLine();
        manageException.checkType(given);

        int trials = Integer.parseInt(given);
        manageException.tryCount(trials);

        return trials;
    }
}
