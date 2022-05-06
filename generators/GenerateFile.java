package generators;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import interfaces.Storable;

public class GenerateFile {
    private Storable object;
    private String path;

    public GenerateFile(Storable object, String path) {
        this.object = object;
        this.path = path;
    }

    public void generate() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(object.infoToStore());
        writer.close();
    }

}
