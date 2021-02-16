package hello.hellospring.domain;

public class Member {

    private Long id; // <- 시스템이 저장할 때 사용할 id, 햇갈릴까봐 long으로 선언함
    private String name; // <- 넘겨줄 이름

    // Alt + Insert 사용하세용 ㅎㅎ Generate 단축키


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
