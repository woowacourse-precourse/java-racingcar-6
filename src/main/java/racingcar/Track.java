package racingcar;

import java.util.List;

public class Track {

    public static void drawtrack(List<Car> cars){

        Move move = new Move();

        for(int i=0; i<cars.size(); i++) {

            System.out.printf(cars.get(i).getName()+" : ");
            move.random_move(cars.get(i));
            move.draw(cars.get(i));
        }

    }


}
