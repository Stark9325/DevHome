package master;

import javax.swing.*;
import java.util.ArrayList;

import static master.shell.getFrame;

/**
 * Created by U_M0SL6 on 29.11.2017.
 */
public class run {
    public static void main(String[] args) {

        String path1 = "D:\\VuserLog\\uc_07_check_clientname_1.log";
        String path2 = "D:\\Dev\\IDEAProjects\\DevHome\\src\\logs";
        String path3 = "D:\\Dev\\IDEAProjects\\DevHome\\src\\logs\\log.txt";
        String mask = "хранилищ";

        shell read = new shell();

        //для списка файлов
        //read.file_list(read.folder_list(path2), mask);

        //для одиночного файла
        read.output(read.input(path3), mask);

        JFrame jFrame = getFrame();

        //TODO Переписать используя перегрузку методов

    }
}
