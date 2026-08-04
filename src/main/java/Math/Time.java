package Math;

public class Time {

    private static Time instance;

    private float deltaTime = 0;
    private float timeScale = 1.0f;
    private long lastTime = System.nanoTime();


    public static Time getInstance(){
        if(instance == null){
            instance = new Time();
        }
        return instance;
    }

    public void update(){
        long now = System.nanoTime();
        deltaTime =  (now - lastTime) / 1_000_000_000.0f;
        lastTime = now;
        if(deltaTime >0.1f){
            deltaTime = 0.1f;
        }
        deltaTime *=timeScale;
    }
    public static float getDeltaTime(){
        return getInstance().deltaTime;
    }

    public static float getRawDeltaTime(){
        return getInstance().deltaTime;
    }
    public static void setTimeScale(float scale){
        getInstance().timeScale = scale;
    }
    public static float getScale(){
        return getInstance().timeScale;
    }

}
