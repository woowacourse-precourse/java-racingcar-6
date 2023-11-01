package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Input input = new Input();
        Track track = new Track();
        Winner winner = new Winner();

        List<Car> cars = input.carname_input();

        int movecount = input.howmanymove();

        System.out.println("\n실행결과");
        for(int i=0; i<movecount; i++){
            track.drawtrack(cars);
            System.out.println("");
        }
        winner.winner(cars);

    }
}
