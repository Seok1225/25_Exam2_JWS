package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MotivationService {
    private ArrayList<Motivation> list = new ArrayList<>();
    private int nextId = 1;

    public void add(String content, String author) {
        Motivation m = new Motivation(nextId++, content, author, LocalDateTime.now());
        list.add(m);
        System.out.println("명언이 등록되었습니다.");
    }

    public void list() {
        if (list.isEmpty()) {
            System.out.println("등록된 명언이 없습니다.");
            return;
        }
        System.out.println("번호 / 명언 / 작가");
        for (Motivation m : list) {
            System.out.printf("%d / %s / %s\n", m.getId(), m.getAuthor(), m.getContent());
        }
    }

    public void detail(int id) {
        Motivation m = findById(id);
        if (m == null) {
            System.out.println("해당 ID의 명언을 찾을 수 없습니다.");
        } else {
            System.out.printf("ID: %d\n작성자: %s\n내용: %s\n등록일: %s\n",
                    m.getId(), m.getAuthor(), m.getContent(), m.getRegDate());
        }
    }

    public void delete(int id) {
        Motivation m = findById(id);
        if (m != null) {
            list.remove(m);
            System.out.println("삭제되었습니다.");
        } else {
            System.out.println("해당 ID의 명언이 없습니다.");
        }
    }

    public void update(int id, String content, String author) {
        Motivation m = findById(id);
        if (m != null) {
            m.setContent(content);
            m.setAuthor(author);
            System.out.println("수정되었습니다.");
        } else {
            System.out.println("해당 ID의 명언이 없습니다.");
        }
    }

    private Motivation findById(int id) {
        for (Motivation m : list) {
            if (m.getId() == id) return m;
        }
        return null;
    }
}
