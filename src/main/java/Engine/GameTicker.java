package Engine;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameTicker {

    private  ScheduledExecutorService executorService;
    private final Runnable gameloop;
    private final int tickIntervalms;


    public GameTicker(int tickIntervalms,Runnable gameloop ) {
        this.gameloop = gameloop;
        this.tickIntervalms = tickIntervalms;
        this.executorService = Executors.newSingleThreadScheduledExecutor();
    }

    public void start() {
        executorService.scheduleAtFixedRate(() -> {
            try {
                gameloop.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, tickIntervalms, TimeUnit.MILLISECONDS);
    }
    public void stop(){
        executorService.shutdown();
    }
}
