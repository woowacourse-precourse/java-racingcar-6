package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Leaderboard;
import racingcar.domain.NamesManager;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        NamesManager namesManager = new NamesManager();
        List<String> namesList = namesManager.separateNamesString(Console.readLine());
        if (namesManager.checkNamesException(namesList)) {
            throw new IllegalArgumentException("중복되는 이름이나 5 글자 이상의 이름이 있는지 확인해주세요.");
        }

        Leaderboard leaderboard = new Leaderboard(namesList);

        System.out.println("시도할 회수는 몇회인가요?");
        int roundNumber;
        String roundNumberString = Console.readLine();
        if (notNumber(roundNumberString)) {
            throw new IllegalArgumentException("입력하신 값이 숫자가 맞는지 확인해주세요.");
        }
        else {
            roundNumber = Integer.parseInt(roundNumberString);

            if (negativeNumber(roundNumber)) {
                throw new IllegalArgumentException("입력하신 값이 0 이상의 수가 맞는지 확인해주세요.");
            }
        }

        System.out.println();
        System.out.println("실행 결과");

        while (roundNumber>0){
            round(leaderboard);

            leaderboard.status();

            roundNumber--;
        }

        leaderboard.winner();
    }

    public static boolean notNumber(String number){
        try {
            Integer.parseInt(number);
        } catch(NumberFormatException e) {
            return true;
        }

        return false;
    }

    public static boolean negativeNumber(Integer number){
        if (number<0) {
            return true;
        }

        return false;
    }

    public static void round(Leaderboard leaderboard){
        for (String name : leaderboard.board.keySet()){
            int currentPlace = leaderboard.board.get(name);

            if (new Car().engine()){
                leaderboard.board.put(name, currentPlace+1);
            }
        }
    }

}
