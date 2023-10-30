package racingcar.domain;

import java.util.List;
import racingcar.utils.RandomUtils;
import racingcar.utils.StringUtils;

public class User {
    private List<Car> carList;
    private CarFactory carFactory;
    private int tryNumber;
    private int randomNumber;
    private InputOutputHandler inputOutputHandler;

    public User(){
        this.tryNumber = inputTryNumber();
        this.randomNumber = RandomUtils.generateRandomNumber();
        this.carList = carFactory.produceCar();
    }

    public void racing(){
        Race race = new Race(tryNumber, randomNumber, carList);

    }

    public List<String> getCarNameList(){
        String carNames = inputCarNames();
        return StringUtils.toStringList(carNames);
    }

    public String inputCarNames(){
        return inputOutputHandler.inputText();
    }

    public int inputTryNumber(){
        return Integer.parseInt(inputOutputHandler.inputText());
    }

}
