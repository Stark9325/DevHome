package master;

import java.util.ArrayList;

/**
 * Created by U_M0SL6 on 29.11.2017.
 */
public interface LocationImpl {
    public String location  = "";
    public String File_name = "";


    public ArrayList<String> input(String File_name);
    public ArrayList<String> output(ArrayList<String> data, String mask);
    public ArrayList<String> folder_list(String path);
    public ArrayList<String> file_list(ArrayList<String> data, String mask);


}
