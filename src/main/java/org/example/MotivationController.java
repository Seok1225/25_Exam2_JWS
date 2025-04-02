package org.example;

import java.util.Scanner;

public class MotivationController {
    private MotivationService service = new MotivationService();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.print("명령어를 입력해주세요 (등록, 목록, 상세보기, 삭제, 수정, 종료): ");
            String cmd = sc.nextLine();

            if (cmd.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언을 입력하세요: ");
                String content = sc.nextLine();
                System.out.print("작가를 입력하세요: ");
                String author = sc.nextLine();
                service.add(content, author);

            } else if (cmd.equals("목록")) {
                service.list();

            } else if (cmd.equals("상세보기")) {
                System.out.print("ID를 입력하세요: ");
                int id = Integer.parseInt(sc.nextLine());
                service.detail(id);

            } else if (cmd.equals("삭제")) {
                System.out.print("ID를 입력하세요: ");
                int id = Integer.parseInt(sc.nextLine());
                service.delete(id);

            } else if (cmd.equals("수정")) {
                System.out.print("ID를 입력하세요: ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("새로운 명언: ");
                String content = sc.nextLine();
                System.out.print("새로운 작가: ");
                String author = sc.nextLine();
                service.update(id, content, author);

            } else {
                System.out.println("지원하지 않는 명령어입니다.");
            }
        }
    }
}
