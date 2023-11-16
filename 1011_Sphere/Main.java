/*
 * Author: João Henrique Silva Pinto
 * Link: https://www.beecrowd.com.br/judge/en/problems/view/1011
 * beecrowd | 1011 Sphere
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double radius = scanner.nextDouble();
        
        double pi = 3.14159;
        double volume = (4.0 / 3) * pi * Math.pow(radius, 3);
        
        System.out.printf("VOLUME = %.3f\n", volume);
        
        scanner.close();
    }
}
