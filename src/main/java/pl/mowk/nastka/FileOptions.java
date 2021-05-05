package pl.mowk.nastka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
import static pl.mowk.nastka.Direction.*;

public class FileOptions {
    public int[][] FileReader(String filename) throws FileNotFoundException {
        File plik = new File(filename);
//        File plik = new File("input.txt");
        Scanner odczyt = new Scanner(plik);
        int tab[] = new int[18];
        for (int i = 0; i < 18; i++) {
            tab[i] = odczyt.nextInt();
        }
        int height = tab[0];
        int width = tab[1];
        int table[][] = new int[height][width];
        for (int k = 0; k < 4; k++) {
            table[0][k] = tab[k + 2];
        }
        for (int k = 0; k < 4; k++) {
            table[1][k] = tab[k + 6];
        }
        for (int k = 0; k < 4; k++) {
            table[2][k] = tab[k + 10];
        }
        for (int k = 0; k < 4; k++) {
            table[3][k] = tab[k + 14];
        }
        odczyt.close();
        System.out.println(Arrays.deepToString(table));
        return table;
    }
    public int getHeight(String filename) throws FileNotFoundException {
        File plik = new File(filename);
//        File plik = new File("input.txt");
        Scanner odczyt = new Scanner(plik);
        int tab[] = new int[18];
        for (int i = 0; i < 18; i++) {
            tab[i] = odczyt.nextInt();
        }
        int height = tab[0];
        odczyt.close();
        return height;
    }
    public int getWidth(String filename) throws FileNotFoundException {
        File plik = new File(filename);
//        File plik = new File("input.txt");
        Scanner odczyt = new Scanner(plik);
        int tab[] = new int[18];
        for (int i = 0; i < 18; i++) {
            tab[i] = odczyt.nextInt();
        }
        int width = tab[1];
        odczyt.close();
        return width;
    }

    public void saveToFile(String filename,int lenght, String result) throws FileNotFoundException {
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

    public Vector<Direction> changeOrder(String order){
        Vector<Direction> order1 = new Vector<>();
        for (int i = 0 ; i < order.length(); i++){
            if (order.charAt(i) == 'L'){
                order1.add(L);
            }
            if (order.charAt(i) == 'U'){
                order1.add(U);
            }
            if (order.charAt(i) == 'D'){
                order1.add(D);
            }
            if (order.charAt(i) == 'R'){
                order1.add(R);
            }
        }
    return order1;
    }
}

