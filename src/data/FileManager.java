package data;

import java.io.*;
import java.util.*;

public class FileManager {

    private static final String BASE_PATH = "c:\\Ayaz's Data\\University\\Semester II\\OOP\\Lab\\Project\\StudentCourseManagementSystem\\StudentCourseManagementSystem\\src\\data\\";

    public static List<String> readAll(String fileName) {
        List<String> lines = new ArrayList<>();
        
        // Combine the base path with the file name
        File file = new File(BASE_PATH + fileName);

        try {
            // This check is technically not needed for absolute paths if the folder exists,
            // but we keep it just in case.
            if (!file.exists()) {
                file.createNewFile();
            }
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) lines.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void writeAll(String fileName, List<String> lines) {
        // Combine the base path with the file name
        File file = new File(BASE_PATH + fileName);
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}