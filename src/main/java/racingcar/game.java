package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class game {
    car[] participate;
    int try_number;
    car[] max_stacks;
    int top;

    String[] input_name(String name_bundle){ //자동차 이름 분류
        String[] names = name_bundle.split(",");

        return names;
    }

    void store_name(){ //자동차 이름 저장
        String name_bundle;
        String[] names;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        name_bundle = readLine();
        names = input_name(name_bundle);

        participate = new car[names.length];
        for(int i = 0; i < names.length; i++){
            participate[i] = new car(names[i], 0);
        }
    }

    void input_trynumber(){ //시도 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        try_number = Integer.parseInt(readLine());
    }

    boolean check_num(int random){ //난수 비교
        if(random < 4){
            return false;
        }

        return true;
    }

    void car_move(car par, boolean check_result){ //자동차 움직임 결정
        if(check_result){
            par.position++;
        }
    }

    void car_position(){ //자동차 마다 위치 이동
        int random;

        for(int i = 0; i < participate.length; i++){
            random = pickNumberInRange(0, 9); //무작위 값 생성
            car_move(participate[i], check_num(random));
        }
        try_number--;
    }

    void print_car(car par){ //자동차 진행 상황 출력
        System.out.print(par.name + " : ");
        for(int i = 0; i < par.position; i++){
            System.out.print("-");
        }
        System.out.println("");
    }

    void print_simul(){ //모든 자동차 상황 출력
        for(int i = 0; i < participate.length; i++){
            print_car(participate[i]);
        }
        System.out.println("");
    }

    void find_max(car par){ //최종 우승자 스택 저장
        if(max_stacks[0] == null){
            max_stacks[++top] = par;
        }
        else if(par.position > max_stacks[0].position){
            top = -1;
            max_stacks[++top] = par;
        }
        else if(par.position == max_stacks[0].position){
            max_stacks[++top] = par;
        }
    }

    void print_max(){ //최종 우승자 출력
        max_stacks = new car[participate.length];
        top = -1;

        for(int i = 0; i < participate.length; i++){
            find_max(participate[i]);
        }

        System.out.print("최종 우승자 : ");

        for(int i = 0; i < top; i++){
            System.out.print(max_stacks[i].name + ", ");
        }
        System.out.println(max_stacks[top].name);
    }
}
