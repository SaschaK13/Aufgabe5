package de.hfu;

import java.util.Scanner;

/**
 * Hello world! What's up?
 * Ich bin ein Test JavaDoc-Kommentar
 *
 * @author Sascha
 * @version 1.0
 */
public class App 
{
    /**
     * Hauptprogramm
     *
     * @param args args
     */
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input.toUpperCase();
        System.out.println(input);
    }
}
