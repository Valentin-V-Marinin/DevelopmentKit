package seminar2.chatServer;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogServerListener implements  iServerListener{

    private String fileName;

    public LogServerListener(String fileName) throws RuntimeException{
        this.fileName = fileName;

        if (!checkFileExists(fileName)) createLogFile(fileName);
    }

    public boolean checkFileExists(String fileName){
        File file = new File(fileName);
        if (file.exists()) return true;
        return false;
    }


    public boolean createLogFile(String path) throws RuntimeException{
        boolean result = false;
        try {
            File file = new File(path);
            try (FileWriter fw = new FileWriter(file, true)) {
                String str = "Лог файл создан " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd hh:mm:ss"));
                fw.write(str + "\n");
                fw.flush();
                result = true;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public void savelog(String msg) throws RuntimeException{
        File file = new File(fileName);
        try (FileWriter fw = new FileWriter(file, true)) {
                fw.write( LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd hh:mm:ss")) +
                       " " + msg + "\n");
                fw.flush();
            } catch (IOException ex) {
            throw new RuntimeException(ex);
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

    @Override
    public void generateMessage(String msg) {
        savelog(msg);
    }
}
