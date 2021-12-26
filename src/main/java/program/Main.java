package program;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n;
//        System.out.println("Введіть розір масива:");
//        n = Integer.parseInt(in.next());
//        int[] mas = new int[n];
//        for (int i = 0; i < n; i++)
//            mas[i] = getRandomNumber(1, 20);
//        for (int item : mas) {
//            System.out.print(item + " ");
//        }
        Person person = new Person();
        person.setFirstName("Славік");
        person.setLastName("Мельник");
        System.out.println(person);
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
