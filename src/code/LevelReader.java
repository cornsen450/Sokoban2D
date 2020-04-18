package code;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class LevelReader {



    private char[][] map;
    private String field;


    public LevelReader(String field) throws IOException {
        this.field = field;

    }

    public void setField(String field) {
        this.field = field;
    }





    public char[][] getMapArray() throws IOException{

        File folder = new File("src/levels/");
        File file = new File(folder, field);
        FileReader fr = new FileReader(file.getPath());
        BufferedReader br = new BufferedReader(fr);

        int lines = 0;
        String l;
        int max_line_length = 0;
        while((l = br.readLine()) != null){
            if(l.length() > max_line_length){
                max_line_length = l.length();
            }
            lines++;
        }

        char[][] map = new char[lines][max_line_length];

        FileReader reader = new FileReader(file.getPath());
        BufferedReader f = new BufferedReader(reader);
        String d;
        int k = 0;
        while((d = f.readLine()) != null){

            for(int i = 0; i< d.length(); i++){
                map[k][i] = d.charAt(i);
            }
            k++;
        }

        br.close();
        f.close();

        return map;
    }



}

