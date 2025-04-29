import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int ano;

    public Livro(int id, String titulo, String autor, int ano) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public int getAno() { return ano; }

    @Override
    public String toString() {
        return "ID: " + id + " | Título: " + titulo + " | Autor: " + autor + " | Ano: " + ano;
    }
}

class Biblioteca {
    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    public void atualizarLivro(int id, String novoTitulo) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                livro.setTitulo(novoTitulo);
                System.out.println("Livro atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void deletarLivro(int id) {
        livros.removeIf(livro -> livro.getId() == id);
        System.out.println("Livro deletado (se existia).");
    }
}

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);

        biblioteca.adicionarLivro(new Livro(1, "Dom Casmurro", "Machado de Assis", 1899));
        biblioteca.adicionarLivro(new Livro(2, "O Alquimista", "Paulo Coelho", 1988));

        biblioteca.listarLivros();

        biblioteca.atualizarLivro(2, "O Alquimista - Nova Edição");
        biblioteca.deletarLivro(1);

        biblioteca.listarLivros();
        sc.close();
    }
}
