package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import model.Player;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class CarRaceGame {

    public static void run() {
        // Application에다가 넣기(?) - 리펙토링
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String userInputName = readLine();
        String[] userNames = saveName(userInputName); //saveName(); 입력
        Player[] players = makePlayers(userNames, userNames.length); // player 생성
        System.out.println("시도할 횟수는 몇회인가요?");
        int gameCount = Integer.parseInt(readLine());
        System.out.println("실행 결과");
        for(int i = 0; i < gameCount; i++){
            printResult(players);
            System.out.println();
        }
        printWinner();

        // 입력한 값 숫자가 맞는지 에러처리기능(추후 메서드 화 시켜야함) - docs 변경 리펙토링
        // printResult(int n) - docs 변경 리펙토링
        //printWinner()

    }
    public static String[] saveName(String userInputName) {
        String[] userNames = userInputName.split(",");
        return userNames;
    }

    public static Player[] makePlayers(String[] userNames, int names) {
        Player[] players = new Player[names];
        for(int i = 0; i < names; i++) {
            players[i] = new Player(userNames[i]);
        }
        return players;
    }
    public static void generateRandomNumber(Player[] players) {
        for(int i = 0; i < players.length; i++) {
            players[i].setRandomNumber(Randoms.pickNumberInRange(0,9));
        }
    }
    public static void printResult(Player[] players) {
        generateRandomNumber(players);
        for(int i = 0; i < players.length; i++){
            System.out.println(players[i].getName() + " : " + players[i].getDistanceLine());
        }
    }
    public static void printWinner() {

    }


}
