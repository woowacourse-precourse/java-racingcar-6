package view;

public class ConsoleOutput implements OutPut{

    @Override
    public void print(String value) {
        System.out.println(value);
    }
}
