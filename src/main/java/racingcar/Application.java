package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Application {

    static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String ROUND_START_MESSAGE = "시도할 회수는 몇회인가요?";
    static final String RESULT_MESSAGE = "실행 결과";
    static final String END_MESSAGE = "최종 우승자";

    static Player[] players;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        initGame();
        playGame();
        endGame();

    }

    private static void initGame(){
        System.out.println(GAME_START_MESSAGE);

        String input = Console.readLine();
        String[] names = input.split(",");

        if(invalidName(names)){
            throw new IllegalArgumentException();
        }

        int numberOfPlayers = names.length;
        players = new Player[numberOfPlayers];
        for(int i = 0; i < numberOfPlayers; i++){
            players[i] = new Player(names[i]);
        }
    }

    private static void playGame(){
        System.out.println(RESULT_MESSAGE);

        String roundStr = Console.readLine();
        int round = checkAndReturnRound(roundStr);

        int numberOfPlayers = players.length;
        while(round-- > 0){
            for (int i = 0; i < numberOfPlayers; i++) {
                if(moveCar()){
                    players[i].updatePosition();
                    players[i].updatePositionStr();

                }
            }

            printCurrentRound();
        }
    }

    private static void endGame() {
        StringBuilder output = new StringBuilder();

        PriorityQueue<Player> playersSorted = new PriorityQueue<>(new Comparator<Player>(){
            @Override
            public int compare(Player p1, Player p2) {
                return p2.position - p1.position;
            }
        });

        int numberOfPlayers = players.length;
        for(int i = 0; i < numberOfPlayers; i++){
            playersSorted.add(players[i]);
        }

        int maxPosition = playersSorted.peek().getPosition();
        List<String> winners = new ArrayList<>();
        while(!playersSorted.isEmpty()){
            Player p = playersSorted.poll();
            if(p.getPosition() == maxPosition){
                winners.add(p.getName());
            }else{
                break;
            }
        }

        if(winners.size() > 1){
            String winnersStr = winners.get(0);
            for (int i = 1; i < numberOfPlayers; i++) {
                winnersStr += String.format(", %s", winners.get(i));
            }
            output.append(END_MESSAGE).append(" : ").append(winnersStr);
        }else if(winners.size() == 1){
            String winner = winners.get(0);
            output.append(END_MESSAGE).append(" : ").append(winner);
        }else{
            throw new IllegalArgumentException();
        }

        System.out.print(output.toString());
    }

    private static boolean invalidName(String[] names){
        for(String name : names){
            if(name.length() > 5 || name.length() == 0){
                return true;
            }
        }

        return false;
    }

    private static int checkAndReturnRound(String input) {
        int result = 0;
        try{
            result = Integer.parseInt(input);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }

        return result;
    }

    private static boolean moveCar(){
        int number = Randoms.pickNumberInRange(0, 9);

        return number >= 4;
    }

    private static void printCurrentRound() {
        StringBuilder output = new StringBuilder();

        int numberOfPlayers = players.length;
        for(int i = 0; i < numberOfPlayers; i++){
            String currentPlayer = String.format("%s : %s", players[i].getName(), players[i].getPositionStr());
            output.append(currentPlayer).append("\n");
        }

        System.out.println(output.toString());
    }

    private static class Player{
        String name;
        int position;
        String positionStr;

        public Player(String name){
            this.name = name;
            this.position = 0;
            this.positionStr = "";
        }

        public Player(String name, int position, String positionStr){
            this.name =  name;
            this.position = position;
            this.positionStr = positionStr;
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }

        public String getPositionStr() {
            return positionStr;
        }

        public void updatePosition(){
            position++;
        }

        public void updatePositionStr(){
            positionStr += "-";
        }
    }

}
