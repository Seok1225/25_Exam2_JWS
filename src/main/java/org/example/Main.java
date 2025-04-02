package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cmd = sc.next();
        System.out.println("== 명언 앱 실행 ==");
        App.run(sc,cmd);
    }
}