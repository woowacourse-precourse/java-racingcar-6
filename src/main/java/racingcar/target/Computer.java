package racingcar.target;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/*
 *컴퓨터가 하는 일을 다루는 클래스
 */
public class Computer {
    /*
     *전진을 결정할 숫자를 만들어내는 메서드
     */
    public List<Integer> getNumber(int size) {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < size) {
            int randomNum = Randoms.pickNumberInRange(0,9);
            computer.add(randomNum);
        }

        return computer;
    }
}
