package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public List<Integer> generateRandomNumbers(int peopleNum){
        List<Integer> randomNumbers = new ArrayList<>();
        for(int i=0; i<peopleNum; i++){
            int randomNumber = generateRandomNumber();
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }

    public int generateRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }
}
