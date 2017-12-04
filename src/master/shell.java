package master;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.valueOf;

/**
 * Created by U_M0SL6 on 29.11.2017.
 */
public class shell implements LocationImpl {
    String File = null;

    @Override
    public ArrayList<String> input(String File_name) {

        int count = 0;
        //this.File = LocationImpl.File_name;
        ArrayList<String> al = new ArrayList<>();
        try{

            FileInputStream fstream = new FileInputStream(File_name);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                al.add(strLine.toLowerCase());
                //System.out.println(strLine);
                count++;
            }
        }catch (IOException e){
            System.out.println("Ошибка");
        }
        finally {
            System.out.println("В файле - " + count + " строк");
        }
        return al;
    }

    @Override
    public ArrayList<String> output(ArrayList<String> output_data, String mask) {

        int count = 0;
        for (int i = 0; i <output_data.size(); i++) {
           if (output_data.get(i).contains(mask)){
               System.out.println(output_data.get(i));
               count++;
           }
        }
        if (count == 0){
            System.out.println("Ошибок с " + mask + " нет");;
        }
        else
            System.out.println("Найдено ошибок - " + count);
        return output_data;
    }

    @Override
    public ArrayList<String> folder_list(String path) {

        int count = 0;
        File directory = new File(path);
        File[] arrFiles = directory.listFiles();
        List<File> list = Arrays.asList(arrFiles);
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i <arrFiles.length; i++) {
            arrayList.add(valueOf(arrFiles[i]));
            count++;
            //System.out.println(arrayList.get(i));
        }
        System.out.println("Количество файлов - " + count);
        return arrayList;
    }

    @Override
    public ArrayList<String> file_list(ArrayList<String> data, String mask) {


        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i <data.size() ; i++) {
            arrayList.add(data.get(i));
        }

        shell read = new shell();
        for (int i = 0; i <arrayList.size() ; i++) {
//            System.out.println(arrayList.get(i));
//            System.out.println(read.input(arrayList.get(i)));
            read.output(read.input(arrayList.get(i)), mask);
        }

        return arrayList;
    }
}
