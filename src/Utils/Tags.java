package Utils;

public enum Tags {
    player("Player"), enemy("Enemy"), item("Item"), object("Object"),plate("Plate"),wall("Wall"),debug("Debug"),debugPlayer("DebugPlayer")
    ,defaultScene("DefaultScene");

    private String tags;


    Tags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return tags;
    }
}
