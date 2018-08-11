import java.io.*;
import java.util.Scanner;

public class RenameMain {

    /*
        @auther: pavithB
     */

    public static void main(String[] arg) throws IOException {

        Scanner sc = new Scanner(System.in);
        String isExit = "1";
        while(isExit.equals("1")) {
            System.out.print("\n\tPlease Enter The Folder Path (ex:- C:\\Users\\userName\\Documents\\Music): ");
            String absolutePath = sc.nextLine() + "\\";

            System.out.print("\n\tPlease Enter The Character to Rename From: ");
            String point = sc.next();

            File folder = new File(absolutePath);
            File[] listOfFiles = folder.listFiles();

            System.out.print("\n\n");
            int outputNumber = 0;
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    File f = new File(absolutePath + listOfFiles[i].getName());
                    String FileName = listOfFiles[i].getName().toString();
                    FileName = FileName.substring(FileName.indexOf(point) + 2);
                    if (!(FileName.length() <= 3)) {
                        outputNumber++;
                        System.out.println("\t\t" + FileName);
//                        boolean a = f.renameTo(new File(absolutePath + FileName));
                        f.renameTo(new File(absolutePath + FileName));
                    }
                }
            }
            System.out.println("\n\n\tconversion is done, " + outputNumber + " files renamed");

            System.out.print("\n\tEnter \'1\' to Continue, Enter any to Exit: ");
            isExit = sc.next();
            absolutePath = "";
            point = "";
        }
    }
}
