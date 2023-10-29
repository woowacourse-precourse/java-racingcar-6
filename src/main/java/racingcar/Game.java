package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Game {

    GameException gameException = new GameException();

    int minNumber = 0;
    int maxNumber = 9;
    public void playGame() {

        ArrayList<String> carName = InputCarName();
        int round = InputRound();

//        System.out.println("실행 결과");
//        int[] result = new int[name.size()];
//        for (int i = 0; count >= i; i++) {
//            for (int j = 0; name.size() > j; j++) {
//                int random = Randoms.pickNumberInRange(minNumber, maxNumber);
//                if (random >= 4) {
//                    System.out.println(name.get(j) + ":" + RandomNumber(result, j));
//                } else {
//
//                }
//            }
//            System.out.println("");
//        }

    }

    private ArrayList<String> InputCarName(){
        ArrayList<String> carName = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] inputName = Console.readLine().split(",");

        for (int i = 0; i < inputName.length; i++){
            carName.add(inputName[i]);
            gameException.NameCount(inputName[i]);
        }
        return carName;
    }

    private int InputRound(){
        int inputRound;

        System.out.println("시도할 회수는 몇회인가요?");
        inputRound = Integer.parseInt(Console.readLine());

        return inputRound;
    }

//    public StringBuilder RandomNumber(int[] result, int j) {
//
//        StringBuilder string = new StringBuilder();
//
//
//        for (int i = 0; result[j] > i; i++) {
//            string.append("-");
//        }
//        return (string);
//    }
//
//    public void ResultText() {
//
//    }
}
