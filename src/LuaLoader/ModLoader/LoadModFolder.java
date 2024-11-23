package LuaLoader.ModLoader;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class LoadModFolder {

    private String root_folder = "./mods/";
    private String example_folder = "/examplemod";
    private String example_script_folder = "./mods/examplemod/scripts";
    private String example_resources_folder = "./mods/examplemod/resources";
    private String example_manifest = "./mods/examplemod";




    private File exampleScriptsFolder = new File(example_script_folder);
    private File example_reosurce_folder = new File(example_resources_folder);
    private File example_manifest_file = new File(example_manifest+"/manifest.xml");


    public LoadModFolder(){

        /** created exmaple file
         *
         */
        if (!exampleScriptsFolder.isDirectory())
            exampleScriptsFolder.mkdirs();
        if (!example_reosurce_folder.isDirectory())
            example_reosurce_folder.mkdirs();
        if (!example_manifest_file.isFile()) {
            try {
                example_manifest_file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public static void main(String[] args) {

       new LoadModFolder();
    }


}
