package racingcar.collaborator;

import java.util.List;
import racingcar.io.Input;
import racingcar.io.Output;

public class Race {

    private List<Racer> racers;
    private Integer numberOfRound;

    public void registerRacer() {
        Output.consoleLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        racers = Input.consoleStrings(",").stream()
                .map(Racer::new)
                .toList();
    }

    public void decideRound() {
        Output.consoleLine("시도할 회수는 몇회인가요?");
        numberOfRound = Input.consoleNumber();
        Output.consoleLine(""); // 입력 후 공백 한 줄이 들어가게 되어있음
    }

    public String run() {
        StringBuilder sb = new StringBuilder();
        while (0 < numberOfRound--) {
            for (Racer racer : racers) {
                racer.drive();
            }
            for (Racer racer : racers) {
                sb.append(racer.getProgress());
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

}
