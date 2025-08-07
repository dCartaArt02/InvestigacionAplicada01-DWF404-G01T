package udb.sv.domain.model;

public class Task {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    private Long id;
    private String Title;
    private boolean completed;

    public Task(Long id, String title, boolean completed) {
        this.id = id;
        this.Title = title;
        this.completed = completed;
    }

}
