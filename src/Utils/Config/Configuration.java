package Utils.Config;


import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

public class Configuration extends Thread{
    private String path_to_config = "./config.cfg";
    private File config_file;
    private Properties properties;


    public Configuration() {
        config_file = new File(path_to_config);
        properties = new Properties();
        if (!(config_file.isFile())) {
            try {
                config_file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}


class Config implements Serializable {

}