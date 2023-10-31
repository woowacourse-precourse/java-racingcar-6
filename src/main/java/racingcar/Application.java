package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        game game = new game();

        game.store_name();
        game.input_trynumber();
        System.out.println("\n실행 결과");
        while(true) {
            game.car_position();
            game.print_simul();
            if(game.try_number == 0) break;
        }
        game.print_max();
    }
}
