package pl.mowk.nastka;

public class Main {

    public static void main(String[] args) {
        System.out.println("Program został wywołany z takimi argumentami:");
        for (String string: args
             ) {
            System.out.print(string);
        }

    }
}

