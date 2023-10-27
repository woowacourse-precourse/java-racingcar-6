package View;

public class GameBoard {

    public void showGameResult(String[] cars, int[] distance) {
        for(int i=0; i<cars.length; i++) {
            System.out.print(cars[i] + " : ");
            for(int j=0; j<distance[i]; j++)
                System.out.print("-");
            System.out.println();
        }
        System.out.println();
    }

    public void showWinner(String[] winner) {
        System.out.print("최종 우승자 : ");
        for(int i=0; i<winner.length; i++) {
            System.out.print(winner[i] + ",");
        }
    }
}
