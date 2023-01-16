package FileService;

import Cats.Cats;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static Cats readJsonFile(String pathToFile) {
        Path parsedPath = Paths.get(pathToFile);
        String fileContents;
        try {
            fileContents = Files.readString(parsedPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return gson.fromJson(fileContents, Cats.class);
    }

    public static void writeJson(Cats cats, String pathToFile) {
        String json = gson.toJson(cats);
        System.out.println(cats);
        System.out.println(json);
        Path parsedPath = Paths.get(pathToFile);
        try {
            Files.writeString(parsedPath, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
