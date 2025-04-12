package Math.GameObjects;

import Utils.Tags;

public interface IAbstractScene {

    public void update();
    public void init();
    public void start();
    public void destroy(Tags tag);

}
