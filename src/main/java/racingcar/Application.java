package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try{
            Game game = new GameBuilder()
                    .getCarsName()
                    .getRoundNumber()
                    .build();

            game.play();
        }finally {
            Console.close();
        }
    }
}
