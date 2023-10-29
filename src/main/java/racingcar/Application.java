package racingcar;

import racingcar.domain.script.Script;

import java.util.HashMap;

import static racingcar.domain.reception.ReceptionDest.registering;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Script.LINEUP.print();
        HashMap<String, Integer> lineUp = registering();
        // hi,my,name,is,hello,world

        System.out.println(lineUp);
    }

}
