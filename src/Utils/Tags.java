package Utils;

public enum Tags {
    player("Player"), enemy("Enemy"), item("Item"), object("Object"),plate("Plate"),wall("Wall"),text("Text");

    private String tags;


    Tags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return tags;
    }
}
