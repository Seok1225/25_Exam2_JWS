[33mcommit 619802007571e88d124600181b89efe675f355f0[m
Author: Seok1225 <koreait6642@gmail.com>
Date:   Wed Apr 2 15:33:40 2025 +0900

    시험

[1mdiff --git a/.idea/gradle.xml b/.idea/gradle.xml[m
[1mindex f07d8ac..446c193 100644[m
[1m--- a/.idea/gradle.xml[m
[1m+++ b/.idea/gradle.xml[m
[36m@@ -1,5 +1,6 @@[m
 <?xml version="1.0" encoding="UTF-8"?>[m
 <project version="4">[m
[32m+[m[32m  <component name="GradleMigrationSettings" migrationVersion="1" />[m
   <component name="GradleSettings">[m
     <option name="linkedExternalProjectsSettings">[m
       <GradleProjectSettings>[m
[1mdiff --git a/src/main/java/org/example/Main.java b/src/main/java/org/example/Main.java[m
[1mindex beacc4e..5a8eb05 100644[m
[1m--- a/src/main/java/org/example/Main.java[m
[1m+++ b/src/main/java/org/example/Main.java[m
[36m@@ -1,13 +1,111 @@[m
 package org.example;[m
 [m
[31m-import java.util.Scanner;[m
[32m+[m[32mimport java.util.*;[m
[32m+[m[32mimport java.time.LocalDateTime;[m
[32m+[m[32mimport java.time.format.DateTimeFormatter;[m
 [m
 public class Main {[m
[32m+[m[32m    static class Motivation {[m
[32m+[m[32m        int id;[m
[32m+[m[32m        String content;[m
[32m+[m[32m        String author;[m
[32m+[m[32m        LocalDateTime regDate;[m
[32m+[m
[32m+[m[32m        public Motivation(int id, String content, String author, LocalDateTime regDate) {[m
[32m+[m[32m            this.id = id;[m
[32m+[m[32m            this.content = content;[m
[32m+[m[32m            this.author = author;[m
[32m+[m[32m            this.regDate = regDate;[m
[32m+[m[32m        }[m
[32m+[m[32m    }[m
[32m+[m
     public static void main(String[] args) {[m
         Scanner sc = new Scanner(System.in);[m
[31m-        String cmd = sc.nextLine();[m
[31m-        new MotivationApp(sc).run(sc,cmd);[m
[32m+[m[32m        List<Motivation> list = new ArrayList<>();[m
[32m+[m[32m        int nextId = 1;[m
[32m+[m
[32m+[m[32m        while (true) {[m
[32m+[m[32m            System.out.print("명령어를 입력해주세요 (등록, 목록, 상세보기, 삭제, 수정, 종료): ");[m
[32m+[m[32m            String cmd = sc.nextLine();[m
[32m+[m
[32m+[m[32m            if (cmd.equals("종료")) {[m
[32m+[m[32m                System.out.println("프로그램을 종료합니다.");[m
[32m+[m[32m                break;[m
[32m+[m[32m            }[m
[32m+[m
[32m+[m[32m            switch (cmd) {[m
[32m+[m[32m                case "등록":[m
[32m+[m[32m                    System.out.print("명언을 입력하세요: ");[m
[32m+[m[32m                    String content = sc.nextLine();[m
[32m+[m[32m                    System.out.print("작가를 입력하세요: ");[m
[32m+[m[32m                    String author = sc.nextLine();[m
[32m+[m[32m                    Motivation m = new Motivation(nextId++, content, author, LocalDateTime.now());[m
[32m+[m[32m                    list.add(m);[m
[32m+[m[32m                    System.out.println("명언이 등록되었습니다.");[m
[32m+[m[32m                    break;[m
[32m+[m
[32m+[m[32m                case "목록":[m
[32m+[m[32m                    if (list.isEmpty()) {[m
[32m+[m[32m                        System.out.println("등록된 명언이 없습니다.");[m
[32m+[m[32m                        System.out.println("번호   /     작가     /    명언");[m
[32m+[m[32m                    } else {[m
[32m+[m[32m                        for (Motivation mot : list) {[m
[32m+[m[32m                            System.out.printf("%d / %s / %s\n", mot.id, mot.author, mot.content);[m
[32m+[m[32m                        }[m
[32m+[m[32m                    }[m
[32m+[m[32m                    break;[m
[32m+[m
[32m+[m[32m                case "상세보기":[m
[32m+[m[32m                    System.out.print("ID를 입력하세요: ");[m
[32m+[m[32m                    int detailId = Integer.parseInt(sc.nextLine());[m
[32m+[m[32m                    Motivation detail = findById(list, detailId);[m
[32m+[m[32m                    if (detail != null) {[m
[32m+[m[32m                        System.out.printf("ID: %d\n작성자: %s\n내용: %s\n등록일: %s\n",[m
[32m+[m[32m                                detail.id, detail.author, detail.content,[m
[32m+[m[32m                                detail.regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));[m
[32m+[m[32m                    } else {[m
[32m+[m[32m                        System.out.println("해당 ID의 명언을 찾을 수 없습니다.");[m
[32m+[m[32m                    }[m
[32m+[m[32m                    break;[m
[32m+[m
[32m+[m[32m                case "삭제":[m
[32m+[m[32m                    System.out.print("ID를 입력하세요: ");[m
[32m+[m[32m                    int deleteId = Integer.parseInt(sc.nextLine());[m
[32m+[m[32m                    Motivation toDelete = findById(list, deleteId);[m
[32m+[m[32m                    if (toDelete != null) {[m
[32m+[m[32m                        list.remove(toDelete);[m
[32m+[m[32m                        System.out.println("명언이 삭제되었습니다.");[m
[32m+[m[32m                    } else {[m
[32m+[m[32m                        System.out.println("해당 ID의 명언이 없습니다.");[m
[32m+[m[32m                    }[m
[32m+[m[32m                    break;[m
[32m+[m
[32m+[m[32m                case "수정":[m
[32m+[m[32m                    System.out.print("ID를 입력하세요: ");[m
[32m+[m[32m                    int updateId = Integer.parseInt(sc.nextLine());[m
[32m+[m[32m                    Motivation toUpdate = findById(list, updateId);[m
[32m+[m[32m                    if (toUpdate != null) {[m
[32m+[m[32m                        System.out.print("새로운 명언: ");[m
[32m+[m[32m                        toUpdate.content = sc.nextLine();[m
[32m+[m[32m                        System.out.print("새로운 작가: ");[m
[32m+[m[32m                        toUpdate.author = sc.nextLine();[m
[32m+[m[32m                        System.out.println("명언이 수정되었습니다.");[m
[32m+[m[32m                    } else {[m
[32m+[m[32m                        System.out.println("해당 ID의 명언이 없습니다.");[m
[32m+[m[32m                    }[m
[32m+[m[32m                    break;[m
[32m+[m
[32m+[m[32m                default:[m
[32m+[m[32m                    System.out.println("지원하지 않는 명령어입니다.");[m
[32m+[m[32m                    break;[m
[32m+[m[32m            }[m
[32m+[m[32m        }[m
[32m+[m[32m    }[m
 [m
[31m-        sc.close();[m
[32m+[m[32m    private static Motivation findById(List<Motivation> list, int id) {[m
[32m+[m[32m        for (Motivation m : list) {[m
[32m+[m[32m            if (m.id == id) return m;[m
[32m+[m[32m        }[m
[32m+[m[32m        return null;[m
     }[m
[31m-}[m
\ No newline at end of file[m
[32m+[m[32m}[m
