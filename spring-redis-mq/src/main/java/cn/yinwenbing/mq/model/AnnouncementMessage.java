package cn.yinwenbing.mq.model;

/**
 * @author yinwenbing
 * @date 2023/2/3 10:13
 */
public class AnnouncementMessage {

    private String id;

    private String content;

    public AnnouncementMessage() {

    }

    public AnnouncementMessage(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AnnouncementMessage{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
