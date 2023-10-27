package racingcar;

import racingcar.entity.Cars;
import racingcar.entity.MovePolicy;
import racingcar.mapper.Delimiter;
import racingcar.mapper.InputMapper;
import racingcar.view.InputView;

import java.util.List;

class Controller {

    private final MovePolicy policy;

    public Controller(MovePolicy policy) {
        this.policy = policy;
    }

    public void run() {
        List<String> names = readNames();
        int tryCount = readTryCount();

        race(tryCount, Cars.from(names));
    }

    private List<String> readNames() {
        Delimiter delimiter = InputMapper.getNameListDelimiter();

        return InputMapper.mapToNameList(InputView.readNames(delimiter.getName(), delimiter.getShape()));
    }

    private int readTryCount() {
        return InputMapper.mapToPositiveNumber(InputView.readTryCount());
    }

    private void race(int tryCount, Cars cars) {
        for (int i = 0; i < tryCount; i++) {

        }
    }
}
