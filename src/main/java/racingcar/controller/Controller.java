package racingcar.controller;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.CarList;
import racingcar.view.OutputView;

public class Controller {

    private static final int THRESHOLD = 4;
    Validate validate = new Validate();
    CarList carList;

    public void makeCarList(List<String> nameList) {
        this.carList = new CarList(nameList);
    }

    public int getAttemptNumber(String strNumber) {
        int number = 0;
        if (validate.validateInteger(strNumber)) {
            number = parseInt(strNumber);
        }
        return number;
    }

    public List<String> getEnteredNames(String inputLine) {
        List<String> inputNames = seperateNames(inputLine);
        validate.validateOverorZero(inputNames);
        validate.validateDuplicate(inputNames);
        return inputNames;
    }

    public List<String> seperateNames(String line) {
        List<String> nameList = new ArrayList<>();
        for (String name : line.split(",")) {
            nameList.add(name);
        }
        return nameList;
    }

    public List<Integer> makeRandomNumberList(int size) {
        List<Integer> randomNums = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomNums.add(new Generator().generateRandomNumber());
        }
        return randomNums;
    }

    /* 입력한 수 만큼 반복 진행
     * 자동차 수 만큼 랜덤한 숫자 만들어서
     * 이걸 carList에 넘겨줌*/
    public void play(int howMany) {
        OutputView outputView = new OutputView();
        while (howMany > 0) {
            List<Integer> randomNums = makeRandomNumberList(carList.getSize());
            carList.updateDistance(replaceZeroAndOne(randomNums));
            outputView.printInterm(carList.toString());
            howMany--;
        }
    }

    public List<Integer> replaceZeroAndOne(List<Integer> randomNumms) {
        return randomNumms.stream().map(s -> {
            if (s >= THRESHOLD) {
                return 1;
            }
            return 0;
        }).collect(Collectors.toList());
    }
    
    public List<String> whoisWinner() {
        return carList.getWinner(carList.getMaxDistance());
    }

}
