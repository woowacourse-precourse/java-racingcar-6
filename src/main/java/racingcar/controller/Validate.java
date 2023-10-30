package racingcar.controller;

import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Validate {

    OutputView outputView = new OutputView();
    public boolean validateName(List<String> nameList){
        for (String name: nameList){
            if (name.length() > 5){
                outputView.printError();
            }
        }
        return true;
    }

    public boolean validateNumber(String number){
        try{
            parseInt(number);
        } catch (NumberFormatException e) {
            outputView.printError();
        }
        return true;
    }

    public List<Integer> replaceZeroAndOne(List<Integer> randomNumms){
        List<Integer> result = randomNumms.stream().map(s -> {
            if (s >= 4) return 1;
            return 0;
        }).collect(Collectors.toList());
        return result;
    }
}
