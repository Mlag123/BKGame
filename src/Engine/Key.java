package Engine;



public class Key {
    private boolean key_right = false;
    private boolean key_left = false;
    private boolean key_up = false;
    private boolean key_down = false;

    public boolean isKey_right() {
        return key_right;
    }

    public void setKey_right(boolean key_right) {
        this.key_right = key_right;
    }

    public boolean isKey_left() {
        return key_left;
    }

    public void setKey_left(boolean key_left) {
        this.key_left = key_left;
    }

    public boolean isKey_up() {
        return key_up;
    }

    public void setKey_up(boolean key_up) {
        this.key_up = key_up;
    }

    public boolean isKey_down() {
        return key_down;
    }

    public void setKey_down(boolean key_down) {
        this.key_down = key_down;
    }

    public boolean isKey_shot() {
        return key_shot;
    }

    public void setKey_shot(boolean key_shot) {
        this.key_shot = key_shot;
    }

    private boolean key_shot = false;

}
