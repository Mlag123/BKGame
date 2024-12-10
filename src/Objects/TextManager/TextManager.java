package Objects.TextManager;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import Engine.Core.Renderer.Render;
import Engine.PanelGame;
import Math.Vector2D;
import Objects.TextManager.Texts.IDynamicText;
import Objects.TextManager.Texts.SimpleText;
import logging.Logging;
import logging.logs;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;


public class TextManager {

    private Graphics2D g2 = PanelGame.g2;

    private ArrayList<SimpleText> textList;
    private Render render;

    public TextManager(ArrayList<SimpleText> textList) {
        this.textList = textList;
    }

    public TextManager() {
        textList = new ArrayList<>();
        render = new Render();
        // drawText();
    }

    public boolean addSimpleText(SimpleText simpleText) {
        textList.add(simpleText);
        return true;
    }

    public boolean removeSimpleText(SimpleText simpleText) {
        for (SimpleText _simpleText : textList) {
            if (String.valueOf(_simpleText.getTag()).equalsIgnoreCase(String.valueOf(simpleText.getTag()))) {
                textList.remove(_simpleText);
                return true;
            }
        }
        Logging.log(logs.warn, "The object " + simpleText.getTag() + "does not exist in the list");
        return false;
    }

    //fixme render static text;
    public void draw(StringBuffer text, Color color, Vector2D position, int dx, int dy) {

        AffineTransform oldTrans = g2.getTransform();
        g2.translate(position.getX(), position.getY());
        g2.setColor(color);
        g2.drawString(String.valueOf(text), dx, dy);
        g2.setTransform(oldTrans);
        Logging.log(logs.warn, "update");
    }

    //fixme render dynamic text;
    public void draw(SimpleText simpleText, IDynamicText iDynamicText, int dx, int dy) {
        String text = String.valueOf(simpleText.text);
        Vector2D position = simpleText.getVector2D();
        Color color = simpleText.getColor();
        AffineTransform oldTrans = g2.getTransform();
        g2.translate(position.getX(), position.getY());
        g2.setColor(color);
        g2.drawString("text", dx, dy);
        g2.setTransform(oldTrans);
    }

    //fixme drawing static text;
    public void drawText() {
        for (SimpleText _simpleText : textList) {

            new RenderText(g2).renderText(_simpleText.getText(), _simpleText.getColor(), _simpleText.getVector2D(), _simpleText.getDeltaTranform());
            System.out.println(textList.size());
        }
    }
/*    //fixme drawing dynamic text?; ?????
    public void drawDynamicText(String dynText) {
        for (StaticText _staticText : textList) {
            Logging.log(String.valueOf(textList.size()));
            draw(_staticText, iDynamicText, 0, 0);
        }
    }*/
/*    public void drawText(String text, Vector2D vector_position) {
        //     Dimension dimension = new Dimension(w,h);
        AffineTransform oldTrans = g2.getTransform();
        g2.translate(vector_position.getX(), vector_position.getY());
        g2.drawString(text, (int) vector_position.getX(), (int) vector_position.getY());

        g2.setTransform(oldTrans);

    }*/


}

class RenderText extends Render {

    private Graphics2D g2;

    public RenderText(Graphics2D g2) {
        this.g2 = g2;
    }


    public void renderText(StringBuffer text, Color color, Vector2D position, Vector2D deltaTranform) {

        if (g2 != null) {
            AffineTransform oldTrans = g2.getTransform();
            g2.translate(position.getX(), position.getY());
            g2.setColor(color);
            g2.drawString(String.valueOf(text), (int) deltaTranform.getX(), (int) deltaTranform.getY());
            g2.setTransform(oldTrans);
        }
    }


}
