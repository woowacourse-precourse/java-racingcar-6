package racingcar.view;

import racingcar.common.constant.GuidePhrases;

import java.sql.SQLOutput;

public class OutputAboutGame {
    public static void PrintCarInputPhrase() {
        System.out.println(GuidePhrases.carInputPhrases);
    }
    public static void PrintAttemptInputPhrase(){
        System.out.println(GuidePhrases.attemptInputPhrases);
    }
}
