package racingcar;

import racingcar.model.GenerateRandomNumber;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        GenerateRandomNumber generator = GenerateRandomNumber.create();

        int randomNumber = generator.getRandomNumber();
        System.out.println(randomNumber);

        
    }
}
