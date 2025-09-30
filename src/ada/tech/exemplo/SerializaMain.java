package ada.tech.exemplo;

import java.io.*;

public class SerializaMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Produto tv = new Produto("sku123", "Smart TV 55'");

        File arquivo = new File("/home/alexaraujo/ada/turmas/1418/tprog/src/resources/tv.dat");
        salvarEmArquivo(tv, arquivo);

        Produto produto = lerDoArquivo(arquivo);

        System.out.printf("\nDescricao produto %s ", produto.getDescricao());

    }

    public static void salvarEmArquivo(Produto produto, File arquivo) throws IOException {
        try (var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(arquivo)))) {
            out.writeObject(produto);
        }
    }

    public static Produto lerDoArquivo(File arquivo) throws IOException, ClassNotFoundException {
        Produto produto = null;
        try (var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(arquivo)))) {
                produto = (Produto)in.readObject();
        } catch (EOFException e) {
            // Tratamento de exceção
        }
        return produto;
    }



}
