package Objects.TextManager.Texts;

import Math.GameObjects.AbstractObject;
import Math.Vector2D;
import Utils.Tags;

import java.awt.*;

public class SimpleText extends AbstractObject {
    public StringBuffer text;
    private Vector2D transform = Vector2D.vectorZero;
    private Vector2D deltaTranform = Vector2D.vectorZero;
    private Color color;

    public SimpleText(Color color,Tags tag, Vector2D position,Vector2D deltaTranform) {
        super(tag);
        transform = position;
        this.deltaTranform = deltaTranform;
        this.text = new StringBuffer("");
        this.color = color;

    }

    public Vector2D getDeltaTranform(){
        return deltaTranform;
    }

/*    public SimpleText(Color color, Tags tag, float x, float y) {
        transform = new Vector2D(x, y);
        this.text = new StringBuffer("");
        System.out.println(text);
        this.color = color;
        this.tag = String.valueOf(tag);


    }*/

    public void setTransform(float x, float y) {
        transform.setX(x);
        transform.setY(y);
    }

    public void setTransform(Vector2D transform) {
        if (transform != null) {
            this.transform = transform;
        }
    }

    public void setText(StringBuffer text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public StringBuffer getText() {
        return text;
    }

    public Vector2D getVector2D() {
        return transform;
    }
}
