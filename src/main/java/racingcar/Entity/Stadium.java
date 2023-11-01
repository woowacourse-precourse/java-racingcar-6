package racingcar.Entity;

import racingcar.Config;
import racingcar.IO.ConsoleInputOutputHelper;
import racingcar.IO.InputOutputHelper;

import java.util.ArrayList;
import java.util.List;

public class Stadium {
    private final List<Racer> cars = new ArrayList<>();
    private int tryCount;
    private final InputOutputHelper ioHelper;

    public Stadium() {
        ioHelper = Config.getSystemIOHelper();
    }

    public void inputRacers() {
        InputOutputHelper ioHelper = new ConsoleInputOutputHelper();
        ioHelper.output("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        saveRacers(ioHelper.input());
    }

    void saveRacers(String inputCars) {
        List<String> carNames = List.of(inputCars.split(","));
        for (String name : carNames) {
            if (name.length() > Config.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(String.format("각 자동차 이름은 %d자 이하여야 한다.", Config.MAX_NAME_LENGTH));
            }
            this.cars.add(Car.create(name, 0));
        }
    }

    public void inputTryCount() {
        ioHelper.output("시도할 회수는 몇회인가요?\n");
        saveTryCount(ioHelper.input());
        ioHelper.output("\n");
    }

    void saveTryCount(String inputNumber) {
        int count;
        try {
            count = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해야 한다.");
        }
        if (count < 0) {
            throw new IllegalArgumentException("음이 아닌 숫자만 입력해야 한다.");
        }
        this.tryCount = count;
    }

    public void runAllRacers() {
        this.cars.forEach(Racer::run);
    }

    public List<Racer> getRacers() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }
}