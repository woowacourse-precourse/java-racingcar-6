package app.template;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class InputTemplate {

    public String execute(String message, Callback callback) {

        try {

            System.out.println(message);

            String result = Console.readLine();

            callback.valid(result);

            return result;

        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("값을 찾을 수 없음");
        }

    }
}
