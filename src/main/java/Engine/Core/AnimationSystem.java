package Engine.Core;

import com.google.gson.Gson;

public class AnimationSystem {
    private Gson json_read;
    private Gson json_mod_read;

    public AnimationSystem(){
        json_read = new Gson();
        json_mod_read = new Gson();

    }

}
