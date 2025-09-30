package ada.tech.exemplo;

import java.io.*;
import java.nio.file.Files;

public class FileMain {

    public static void main(String[] args) {

        File file = new File("/home/alexaraujo/ada/turmas/1418/tprog/src/resources/teste.txt");
        File file2 = new File("/home/alexaraujo/ada/turmas/1418/tprog/src/resources/teste2.txt");

//        if(!file2.exists()) {
//            try {
//                file2.createNewFile();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }

        try {
            Files.copy(file.toPath(), file2.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        file2.deleteOnExit();

    /*    try {
            copiar(new FileInputStream(file), new FileOutputStream(file2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

    }

    public static void copiar(InputStream in, OutputStream out) throws IOException {
        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }
    }

}
