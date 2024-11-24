package LuaLoader.ModLoader;

import com.google.gson.Gson;

import javax.swing.*;
import java.io.*;

public class LoadModFolder {
    private String namemod = "example_mod_name";
    private String modID = "exampleMODID";
    private String modDescription = "Example mod description";
    private Gson io_json;
    private BufferedReader br;
    private BufferedWriter bw;
    private String root_folder = "./mods/";
    private String example_folder = "/examplemod";
    private String example_script_folder = "./mods/examplemod/scripts";
    private String example_resources_folder = "./mods/examplemod/resources";
    private String example_manifest = "./mods/examplemod";


    private File exampleScriptsFolder = new File(example_script_folder);
    private File example_reosurce_folder = new File(example_resources_folder);
    private File example_manifest_file = new File(example_manifest + "/manifest.json");


    public LoadModFolder() {

        io_json = new Gson();

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


    private boolean writeManifest() {
        exampleMod exampleMod = new exampleMod(namemod, modID,modDescription);
        String json = io_json.toJson(exampleMod);
        try {
            bw = new BufferedWriter(new FileWriter(example_manifest_file));
            bw.write(json);
            bw.flush();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}


class exampleMod implements Serializable {


    private String namemod = "example_mod_name";
    private String modID = "exampleMODID";
    private String modDescription = "modDescription";


    public exampleMod(String namemod, String modID, String modDescription) {
        this.modID = modID;
        this.namemod = namemod;
        this.modDescription = modDescription;
    }


}
