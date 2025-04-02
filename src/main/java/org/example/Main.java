package org.example;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    static class Motivation {
        int id;
        String content;
        String author;
        LocalDateTime regDate;

        public Motivation(int id, String content, String author, LocalDateTime regDate) {
            this.id = id;
            this.content = content;
            this.author = author;
            this.regDate = regDate;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Motivation> list = new ArrayList<>();
        int nextId = 1;

        while (true) {
            System.out.print("명령어를 입력해주세요 (등록, 목록, 상세보기, 삭제, 수정, 종료): ");
            String cmd = sc.nextLine();

            if (cmd.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (cmd) {
                case "등록":
                    System.out.print("명언을 입력하세요: ");
                    String content = sc.nextLine();
                    System.out.print("작가를 입력하세요: ");
                    String author = sc.nextLine();
                    Motivation m = new Motivation(nextId++, content, author, LocalDateTime.now());
                    list.add(m);
                    System.out.println("명언이 등록되었습니다.");
                    break;

                case "목록":
                    if (list.isEmpty()) {
                        System.out.println("등록된 명언이 없습니다.");
                        System.out.println("번호   /     작가     /    명언");
                    } else {
                        for (Motivation mot : list) {
                            System.out.printf("%d / %s / %s\n", mot.id, mot.author, mot.content);
                        }
                    }
                    break;

                case "상세보기":
                    System.out.print("ID를 입력하세요: ");
                    int detailId = Integer.parseInt(sc.nextLine());
                    Motivation detail = findById(list, detailId);
                    if (detail != null) {
                        System.out.printf("ID: %d\n작성자: %s\n내용: %s\n등록일: %s\n",
                                detail.id, detail.author, detail.content,
                                detail.regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    } else {
                        System.out.println("해당 ID의 명언을 찾을 수 없습니다.");
                    }
                    break;

                case "삭제":
                    System.out.print("ID를 입력하세요: ");
                    int deleteId = Integer.parseInt(sc.nextLine());
                    Motivation toDelete = findById(list, deleteId);
                    if (toDelete != null) {
                        list.remove(toDelete);
                        System.out.println("명언이 삭제되었습니다.");
                    } else {
                        System.out.println("해당 ID의 명언이 없습니다.");
                    }
                    break;

                case "수정":
                    System.out.print("ID를 입력하세요: ");
                    int updateId = Integer.parseInt(sc.nextLine());
                    Motivation toUpdate = findById(list, updateId);
                    if (toUpdate != null) {
                        System.out.print("새로운 명언: ");
                        toUpdate.content = sc.nextLine();
                        System.out.print("새로운 작가: ");
                        toUpdate.author = sc.nextLine();
                        System.out.println("명언이 수정되었습니다.");
                    } else {
                        System.out.println("해당 ID의 명언이 없습니다.");
                    }
                    break;

                default:
                    System.out.println("지원하지 않는 명령어입니다.");
                    break;
            }
        }
    }

    private static Motivation findById(List<Motivation> list, int id) {
        for (Motivation m : list) {
            if (m.id == id) return m;
        }
        return null;
    }
}
