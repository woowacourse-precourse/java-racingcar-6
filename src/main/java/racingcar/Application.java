package racingcar;

import racingcar.domain.Judgement;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Output;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        List<String> car = askName();
        int num = tryNum();

        System.out.println(car);
        System.out.println(num);

        NumberGenerator generator = new NumberGenerator();
        Judgement judgement = new Judgement();
        Output output = new Output();

        List<Integer> fowardCount = new ArrayList<>();
        for(int i = 0; i < car.size(); i++){
            fowardCount.add(0);
        }

        System.out.println("실행 결과");

        for(int i = 0; i < num; i++){
            List<Integer> computer = generator.createRandomNumber();
            System.out.println(computer);

            List<Boolean> morethan4 = judgement.correctCount(computer);
            System.out.println(morethan4);

            List<Integer> number = output.gameStart(computer, morethan4, fowardCount);
            System.out.println(number);

            output.log(car, fowardCount);
        }

        List<String> winnerName = output.winner(car, fowardCount);

        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winnerName.size(); i++){
            System.out.print(winnerName.get(i));
            if(i == winnerName.size() - 1) break;
            System.out.print(", ");
        }


    }

    public static List<String> askName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();

        List<String> carNames = new ArrayList<>();
        for(String name : input.split(",")){
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름이 5자가 넘습니다.");
            }
            carNames.add(name);
        }
        return carNames;
    }

    public static int tryNum(){
        System.out.println("시도할 회수는 몇회인가요?");
        int input = Integer.parseInt(readLine());

        return input;
    }
}
