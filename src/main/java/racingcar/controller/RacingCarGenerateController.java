package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarRepository;

public class RacingCarGenerateController {
    private CarRepository carRepository = CarRepository.getInstance();
    static final int NAME_LENGTH = 5;
    private String[] nameArr;

    public void generateCar(String inputName) {
        checkNull(inputName);
        splitNames(inputName);
        setCarList();
    }

    void splitNames(String t) {
        nameArr = t.split(",");
        checkLength();
    }

    void setCarList() {
        for (String s : nameArr)
            carRepository.insertCar(new Car(s, 0));
    }

    public int setRacingCount(String inputCount) {
        checkNull(inputCount);
        checkDigit(inputCount);
        return Integer.parseInt(inputCount);
    }

    void checkNull(String s) {
        if (s.equals("\n")) throw new IllegalArgumentException();
    }

    void checkLength() {
        for (String name : nameArr)
            if (name.length() > NAME_LENGTH) throw new IllegalArgumentException();
    }

    void checkDigit(String s) {
        int i = 0;
        while (i < s.length()) {
            if (!Character.isDigit(s.charAt(i))) throw new IllegalArgumentException();
            i++;
        }
    }
}
