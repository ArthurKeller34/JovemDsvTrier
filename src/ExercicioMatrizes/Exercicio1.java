package ExercicioMatrizes;
import javax.swing.JOptionPane;
public class Exercicio1 {
public static void main(String[] args) {
	

	class Turma {
	    private static String[] alunos;
	    private static double[][] notas;
	    private static int numeroAlunos;
	    private static int numeroProvas;

	    public static void main(String[] args) {
	        numeroAlunos = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de alunos:"));
	        numeroProvas = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de provas:"));

	        alunos = new String[numeroAlunos];
	        notas = new double[numeroAlunos][numeroProvas];

	        cadastrarAlunosENotas();

	        String[] opcoes = {
	            "Listar Alunos", 
	            "Buscar Aluno por Nome", 
	            "Listar Alunos Aprovados", 
	            "Listar Alunos em Recuperação", 
	            "Listar Alunos Reprovados", 
	            "Sair"
	        };
	        int opcao;

	        do {
	            opcao = JOptionPane.showOptionDialog(
	                null, 
	                "Escolha uma opção", 
	                "Menu", 
	                JOptionPane.DEFAULT_OPTION, 
	                JOptionPane.INFORMATION_MESSAGE, 
	                null, 
	                opcoes, 
	                opcoes[0]
	            );

	            switch (opcao) {
	                case 0:
	                    listarAlunos();
	                    break;
	                case 1:
	                    String nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
	                    buscarAlunoPorNome(nome);
	                    break;
	                case 2:
	                    listarAlunosAprovados();
	                    break;
	                case 3:
	                    listarAlunosEmRecuperacao();
	                    break;
	                case 4:
	                    listarAlunosReprovados();
	                    break;
	                case 5:
	                    JOptionPane.showMessageDialog(null, "Saindo...");
	                    break;
	                default:
	                    JOptionPane.showMessageDialog(null, "Opção inválida.");
	            }
	        } while (opcao != 5);
	    }

	    private static void cadastrarAlunosENotas() {
	        for (int i = 0; i < numeroAlunos; i++) {
	            alunos[i] = JOptionPane.showInputDialog("Digite o nome do aluno " + (i + 1) + ":");

	            for (int j = 0; j < numeroProvas; j++) {
	                notas[i][j] = Double.parseDouble(JOptionPane.showInputDialog(
	                    "Digite a nota da prova " + (j + 1) + " para " + alunos[i] + ":"
	                ));
	            }
	        }
	    }

	    private static void listarAlunos() {
	        StringBuilder sb = new StringBuilder("Lista de Alunos:\n");
	        for (int i = 0; i < numeroAlunos; i++) {
	            double media = calcularMedia(notas[i]);
	            String situacao = determinarSituacao(media);
	            sb.append(alunos[i]).append(" - Média: ").append(media).append(" - Situação: ").append(situacao).append("\n");
	        }
	        JOptionPane.showMessageDialog(null, sb.toString());
	    }

	    private static void buscarAlunoPorNome(String nome) {
	        boolean encontrado = false;
	        for (int i = 0; i < numeroAlunos; i++) {
	            if (alunos[i].equalsIgnoreCase(nome)) {
	                double media = calcularMedia(notas[i]);
	                String situacao = determinarSituacao(media);
	                JOptionPane.showMessageDialog(null, alunos[i] + " - Média: " + media + " - Situação: " + situacao);
	                encontrado = true;
	                break;
	            }
	        }
	        if (!encontrado) {
	            JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
	        }
	    }

	    private static void listarAlunosAprovados() {
	        StringBuilder sb = new StringBuilder("Alunos Aprovados:\n");
	        for (int i = 0; i < numeroAlunos; i++) {
	            double media = calcularMedia(notas[i]);
	            if (media >= 7) {
	                sb.append(alunos[i]).append(" - Média: ").append(media).append("\n");
	            }
	        }
	        JOptionPane.showMessageDialog(null, sb.toString());
	    }

	    private static void listarAlunosEmRecuperacao() {
	        StringBuilder sb = new StringBuilder("Alunos em Recuperação:\n");
	        for (int i = 0; i < numeroAlunos; i++) {
	            double media = calcularMedia(notas[i]);
	            if (media >= 3 && media < 7) {
	                sb.append(alunos[i]).append(" - Média: ").append(media).append("\n");
	            }
	        }
	        JOptionPane.showMessageDialog(null, sb.toString());
	    }

	    private static void listarAlunosReprovados() {
	        StringBuilder sb = new StringBuilder("Alunos Reprovados:\n");
	        for (int i = 0; i < numeroAlunos; i++) {
	            double media = calcularMedia(notas[i]);
	            if (media < 3) {
	                sb.append(alunos[i]).append(" - Média: ").append(media).append("\n");
	            }
	        }
	        JOptionPane.showMessageDialog(null, sb.toString());
	    }

	    private static double calcularMedia(double[] notas) {
	        double soma = 0;
	        for (double nota : notas) {
	            soma += nota;
	        }
	        return soma / notas.length;
	    }

	    private static String determinarSituacao(double media) {
	        if (media >= 7) {
	            return "Aprovado";
	        } else if (media < 3) {
	            return "Reprovado";
	        } else {
	            return "Recuperação";
	        }
	    }
	}

}
}
