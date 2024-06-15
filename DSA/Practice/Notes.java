package DSA.Practice;

public class Notes {
    private Integer tag;
    private String name;
    private Integer value;
    public Notes(Integer tag, String name, Integer value) {
        this.tag = tag;
        this.name = name;
        this.value = value;
    }



    public int getTag() {
        return tag;
    }

    public void setTag(int id) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
