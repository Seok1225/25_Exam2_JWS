package org.example;

import java.util.Scanner;

//- 등록 write , 목록 list , 상세보기 detail , 삭제 delete , 수정 modify 의 기능을 구현한다
public class MotivationApp {
    public MotivationApp(Scanner sc) {
    }

    public static void run(Scanner sc, String cmd) {
        System.out.println("== 명언 앱 실행 ==");
        System.out.print("명령어 ) ");
        if (cmd.equals("종료")) {
            System.out.println("== 명언 앱 종료 ==");

        } else if (cmd.equals("등록")) {
            System.out.println("명언 : ");
            sc.nextLine();
            System.out.println("작가: ");
            sc.nextLine();
            cmd = sc.nextLine();
        } else if (cmd.equals("목록")) {
            System.out.println("번호    /    작가     /     명언");

        } else if (cmd.equals("상세보기")) {

        } else if (cmd.equals("삭제")) {

        } else if (cmd.equals("수정")) {

        }
    }
}
