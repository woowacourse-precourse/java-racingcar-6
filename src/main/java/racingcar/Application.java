package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //1. 자동차 이름 입력 -> List로 저장 / 횟수
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        List<String> carNames = new ArrayList<>();
        List<Integer> steps = new ArrayList<>();
        for(String name : inputNames.split(",")){
            carNames.add(name);
            steps.add(0);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int times = Integer.parseInt(Console.readLine());

        printProcess(carNames, steps);
        addSteps(steps);
        printProcess(carNames, steps);

    }

    //랜덤 숫자 생성
    public static void addSteps(List<Integer> steps){
        for(int i = 0; i < steps.size(); i++) {
            int randomNumbers = Randoms.pickNumberInRange(0, 9);
            System.out.println(randomNumbers);
            steps.set(i, steps.get(i) + randomNumbers);
        }
    }

    //실행 결과 출력
    public static void printProcess(List<String> carNames, List<Integer> steps){
        String str = "";
        for(int i = 0; i < carNames.size(); i++){
            str += carNames.get(i) + " : ";
            for(int j = 0; j < steps.get(i); j++){
                str += "-";
            }
            str += "\n";
        }
        System.out.println(str);
    }
}
