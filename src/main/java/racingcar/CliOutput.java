package racingcar;

public class CliOutput {

    public CliOutput() { }

    public void printPrompt(CliPrompt prompt) {
        System.out.print(prompt);
    }

    public void printMsgWithPrompt(CliPrompt prompt, String msg) {
        System.out.println(prompt.toString() + msg);
    }
}
