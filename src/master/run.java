package master;

import java.util.ArrayList;

/**
 * Created by U_M0SL6 on 29.11.2017.
 */
public class run {
    public static void main(String[] args) {

        String path1 = "D:\\VuserLog\\uc_07_check_clientname_1.log";
        String path2 = "D:\\log2";
        String path3 = "D:\\VuserLog\\text.txt";
        String mask = "error";

        shell read = new shell();

        //для списка файлов
        read.file_list(read.folder_list(path2), mask);

        //для одиночного файла
        //read.output(read.input(path3), mask);

        //TODO Переписать используя перегрузку методов

    }
}
