package pl.mowk.nastka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import static pl.mowk.nastka.Direction.*;

public class FileOptions {
    public byte[][] fileReader(String filename) throws FileNotFoundException {
        File plik = new File(filename);
        Scanner odczyt = new Scanner(plik);
        int height = odczyt.nextInt();
        int width = odczyt.nextInt();
        byte[][] tab = new byte[height][width];
        for (int i = 0; i < width * height; i++) {
            tab[i / height][i % width] = odczyt.nextByte();
        }
        odczyt.close();
        return tab;
    }


    public void saveToFile(String filename, int lenght, String result) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter(filename);
        zapis.println(lenght);
        zapis.print(result);
        zapis.close();
    }

    public void saveToFile2(String filename, String result) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter(filename);
        zapis.print(result);
        zapis.close();
    }

    public List<Direction> changeOrder(String order) {
        List<Direction> order1 = new ArrayList<>();
        for (int i = 0; i < order.length(); i++) {
            if (order.charAt(i) == 'L') {
                order1.add(L);
            }
            if (order.charAt(i) == 'U') {
                order1.add(U);
            }
            if (order.charAt(i) == 'D') {
                order1.add(D);
            }
            if (order.charAt(i) == 'R') {
                order1.add(R);
            }
        }
        return order1;
    }
}

