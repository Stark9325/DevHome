package master;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.beans.EventHandler;
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
            System.out.println("В файле " + File_name + " " + count + " строк");
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
           // System.out.println("Ошибок с " + mask + " нет");;
        }
        else
            System.out.println("Найдено " + count + " совпадений");
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

        shell shell = new shell();
        for (int i = 0; i <arrayList.size() ; i++) {
//            System.out.println(arrayList.get(i));
//            System.out.println(shell.input(arrayList.get(i)));
            shell.output(shell.input(arrayList.get(i)), mask);
        }

        return arrayList;
    }

    public static JFrame getFrame(){

        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(500,500);
       //Для рисования
       // jFrame.add(new MyComponent());
        //Создаем панель ?
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);

        //Создаем кнопку под названием submit
        JButton jb = new JButton("submit");
        jPanel.add(jb);
        /*
        * добавляем листенер который отслеживает эвент(нажатие на кнопку) и создаем анонимный класс с функционалом
        * который активируется после нажатия этой кнопки
        * */
//        jb.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //jPanel.setBackground(Color.BLUE);
//                jFrame.setTitle(((JButton) e.getSource()).getText());
//            }
//        }
//        );
        //Аналог кода выше
        jb.addActionListener(EventHandler.create(ActionListener.class, jFrame, "title", "source.text"));

        return jFrame;
    }

    public static class MyComponent extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {

            String img = "D:\\Dev\\IDEAProjects\\DevHome\\src\\img1.jpg";

            //Указываем шрифт
            Font font = new Font("Arial", Font.BOLD,20);
            Graphics2D g2 = (Graphics2D)g;
            g2.setFont(font);
            //Пишем слово
            //g2.drawString("Hello World", 20, 20);
            //Создаем линию
//            Line2D l2 = new Line2D.Double(70, 70, 90, 90);
//            g2.draw(l2);
            //Добавляем в фон изображение по координатам
            Image image = new ImageIcon(img).getImage();
            g2.drawImage(image, 100, 100, null);

        }
    }

}
