package seminar1.chat;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private String fileName;
    private String path;

    public Logger(String fileName, String path) {
        this.fileName = fileName;
        this.path = path;
    }

    public Logger(){
        this.fileName = "";
        this.path = "";
    }

    public boolean checkPath(String path){
        File file = new File(path);
        if (file.exists()) return true;
        return false;
    }

    public boolean createLogFile(String path) throws RuntimeException{
        boolean result = false;
        try {
            File file = new File(path);
            try (FileWriter fw = new FileWriter(file, true)) {
                String str = "Лог файл создан " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd hh:mm:ss"));
                fw.write(str);
                fw.flush();
                result = true;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public void savelog(JTextArea field)throws RuntimeException{
        try {
            File file = new File(fileName);
            try (FileWriter fw = new FileWriter(file, true)) {
                int lines = field.getLineCount();

                for (int i = 0; i < lines; i++) {
                    int start = field.getLineStartOffset(i);
                    int end = field.getLineEndOffset(i);
                    fw.write(field.getText(start, end - start));
                }
                fw.flush();
            }
        } catch (IOException | BadLocationException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadLog(JTextArea field){
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                field.append(line + "\n");
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        if (fileName.equals("Введите сервер")) {
            this.fileName = "chat.txt";
        } else {
            this.fileName = fileName;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
