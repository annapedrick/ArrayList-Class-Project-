//Pedri017 park1394
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class ElephantReader {

    public static boolean readElephants(ElephantHerd e, String fileName) {
        Scanner elephantFile= null;
        int commaIndex;
        String name;
        Scanner line;
        int age;
        double height;
        if(e!=null){
            e.getHerd().clear();
        }
        else{
            return false;
        }

        try {
            elephantFile=new Scanner(new File(fileName));

        } catch (Exception b){
            return false;
        }
        while(elephantFile.hasNextLine() ){

            line = new Scanner(elephantFile.nextLine());
            name = line.next();
            age = Integer.parseInt(line.next());
            height = Double.parseDouble(line.next());
            Elephant tempElephant = new Elephant(name, age, height);
            e.add(tempElephant);
        }
        return true;
    }

    public static boolean writeElephants(ElephantHerd e, String fileName) {
        PrintWriter p = null; // declare p outside try-catch block
        if(e==null) {
            return false;
        }

        try {
            p = new PrintWriter(new File(fileName));
        } catch (Exception b) {
            return false;
        }
        p.write(e.getHerd().toString());
        p.close();
        return true;
    }
    public static void main(String[] args){
        ElephantHerd e=new ElephantHerd();
        Elephant el=new Elephant("ellie", 4, 2.3);
        e.add(el);
        readElephants(e,"ElephantText.txt");
        writeElephants(e, "out.txt");

    }
    }