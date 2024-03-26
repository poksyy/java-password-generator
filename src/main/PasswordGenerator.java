package main;

import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of passwords to generate:");
        int numPw = sc.nextInt();
        System.out.print("Length of passwords to generate:");
        int numPwLength = sc.nextInt();

        String[] randomPasswords = new String[numPw];

        for (int i = 0; i < numPw; i++) {
            StringBuilder randomPasswordBuilder = new StringBuilder();
            for (int j = 0; j < numPwLength; j++) {
                randomPasswordBuilder.append(randomCharacter());
            }
            randomPasswords[i] = randomPasswordBuilder.toString();
        }
        printPasswords(randomPasswords);
    }

    public static void printPasswords(String[] arrayPassword) {
        for (String password : arrayPassword) {
            System.out.println(password);
        }
    }

    public static char randomCharacter() {
        int rand = (int) (Math.random() * 62);

        if (rand <= 9) {
            return (char) (rand + 48); // '0'-'9' => 48-57 IN ASCII
        } else if (rand <= 35) {
            return (char) (rand - 10 + 65); // 'A'-'Z' => 65-90 IN ASCII
        } else {
            return (char) (rand - 36 + 97); // 'a'-'z' => 97-122 IN ASCII
        }
    }
}
