package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        String[] carNamesSplit = splitCarName(carNames);
        String[] finalCarNames = carNameUpperThenFive(carNamesSplit);

        System.out.println("시도할 횟수는 몇회인가요?");
        String inputTryNumber = Console.readLine();
        int tryNum = getTryNumber(inputTryNumber);

        List<String> winner = new ArrayList<>();
        int[] finalCarMove = new int[finalCarNames.length];

        System.out.println("실행 결과");
        for(int i=0; i<tryNum; i++){
            updateGameResult(finalCarNames, winner, finalCarMove);
        }

        System.out.print("최종 우승자 : ");
        String result = finalWinners(winner);
        System.out.println(result);
    }


    public static String[] splitCarName(String carNames){
        return carNames.split(",");
    }


    public static String[] carNameUpperThenFive(String[] carNames){
        for(String name : carNames){
            if(name.length() > 5){
                throw new IllegalArgumentException("이름의 길이가 5보다 크다.");
            }
        }
        return carNames;
    }

    public static int getTryNumber(String tryNumber) {
        try {
            int tryNum = Integer.parseInt(tryNumber);
            if (tryNum < 0) {
                throw new IllegalArgumentException("시도 횟수는 음수일 수 없습니다.");
            }
            return tryNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }
    }

    public static int createRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public static int carMove(int randomNumber){
        int moving = 0;
        if(randomNumber >= 4){
            moving = 1;
        }
        return moving;
    }

    public static void carFrontGo(String carName, int moving){
        System.out.print(carName + " : ");
        for(int i=0; i<moving; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void updateGameResult(String[] carNames, List<String> winner, int[] carMoves){
        int maxMove = 0;
        for(int i=0; i<carNames.length; i++){
            int moving = carMove(createRandomNumber());
            carMoves[i] += moving;
            carFrontGo(carNames[i], carMoves[i]);

            if(carMoves[i] > maxMove){
                maxMove = carMoves[i];
                winner.clear();
                winner.add(carNames[i]);
            } else if (carMoves[i] == maxMove) {
                winner.add(carNames[i]);
            }
        }
        System.out.println();
    }

    public static String finalWinners(List<String> winner){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<winner.size(); i++){
            stringBuilder.append(winner.get(i));
            if(i < winner.size()-1){
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }




}
