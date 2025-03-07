package aluno;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;

public class Util {

    private List<Aluno> listaAluno = new ArrayList<>();

    public void menu() {
        String aux = "Escolha opção\n";
        aux += "1. Cadastrar aluno\n";
        aux += "2. Pesquisar aluno\n";
        aux += "3. Imprimir aluno\n";
        aux += "4. Finalizar";
        int opcao = 0;

        do {
            opcao = Integer.parseInt(showInputDialog(null, aux));
            if (opcao < 1 || opcao > 4) {
                showMessageDialog(null, "Opção inválida");
            } else {
                switch (opcao) {
                    case 1:
                        cadastrar();
                        break;
                    case 2:
                        pesquisar();
                        break;
                    case 3:
                        imprimir();
                        break;
                }
            }
        } while (opcao != 4);

    }

    private void imprimir() {
        String aux = "";
        for(Aluno aluno : listaAluno) {
            aux += aluno + "\n";
        }
        showMessageDialog(null, aux);
    }

    private void pesquisar() {
        int ra = parseInt(showInputDialog("Informe o RA para pesquisa"));
        for (Aluno aluno : listaAluno) {
            if (aluno.getRa() == ra) {                
                showMessageDialog(null, aluno.getNome() + " está matriculado");
                return;
            }
        }
        showMessageDialog(null, ra + " não encontrado");
    }

    // método para cadastrar um aluno
    private void cadastrar() {
        int ra = parseInt(showInputDialog("RA"));
        String nome = showInputDialog("Nome");
        listaAluno.add(new Aluno(ra, nome));
    }

}
