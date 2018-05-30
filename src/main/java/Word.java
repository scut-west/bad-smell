public class Word {
    private String text;
    private int count;

    public Word(String text, int count) {
        this.text = text;
        this.count = count;
    }

    public String getText() {
        return this.text;
    }

    public int getCount() {
        return this.count;
    }
}
