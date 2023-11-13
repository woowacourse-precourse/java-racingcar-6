package racingcar;

import racingcar.domain.Judgement;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Output;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // 입력 메소드 실행
        List<String> car = askName();
        int num = tryNum();

        // 사용할 클래스 생성자 미리 생성
        NumberGenerator generator = new NumberGenerator();
        Judgement judgement = new Judgement();
        Output output = new Output();

        // 전진 횟수 count를 위한 List 생성 및 초기화
        List<Integer> fowardCount = new ArrayList<>();
        for(int i = 0; i < car.size(); i++){
            fowardCount.add(0);
        }

        System.out.println("실행 결과");

        for(int i = 0; i < num; i++){
            List<Integer> computer = generator.createRandomNumber();
            List<Boolean> morethan4 = judgement.correctCount(computer);
            output.gameStart(morethan4, fowardCount);
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

    // 경주 참가 자동차명 입력
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

    // 게임 횟수 입력
    public static int tryNum(){
        System.out.println("시도할 회수는 몇회인가요?");
        int input = Integer.parseInt(readLine());

        return input;
    }
}
