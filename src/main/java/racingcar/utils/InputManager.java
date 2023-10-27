package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 입력 처리
 */
public enum InputManager {
    INPUT_NAME {//사용자 이름 입력
        @Override
        public List<String> input() {
            try{
                String input = Console.readLine();
                String[] nameList = input.split(",");
                for (String name : nameList)
                    if(name.length()>5)
                        throw new RuntimeException();
                return List.of(nameList);
            }catch (RuntimeException e){
                throw new IllegalArgumentException();
            }
        }
    },
    INPUT_MOVE_COUNT{// 시행 횟수 입력
        @Override
        public Integer input() {
            try{
                String input = Console.readLine();
                if(Integer.parseInt(input)<0)
                    throw new IllegalArgumentException();
                return Integer.parseInt(input);
            }catch (NumberFormatException e){
                throw new IllegalArgumentException();
            }
        }
    };




    // TODO: 2023-10-27 오후 4:31  입력 상황에 맞게 입력 예외 처리
    /*
        사용자 이름 입력
        시행 횟수 입력
     */
    public abstract Object input();
}
