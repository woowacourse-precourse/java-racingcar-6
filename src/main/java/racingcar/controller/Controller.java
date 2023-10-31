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

    /*
     * makeRandomNumberList에서 CasList만큼의 랜덤한 숫자가 들어간 배열을 생성한다 Arrays.asList(9,3,5,1,7)
     * replaceZeroAndOne에서 4이상은 1, 4 미만은 0으로 바꾸어서 리턴한다          Arrays.asList(1,0,1,0,1)
     * 61번 줄 carList.updateDistance에서 carList에 하나씩 들어가 distance를 업데이트한다
     * */
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
