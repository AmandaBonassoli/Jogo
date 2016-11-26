import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {

	static JFrame janela = new JFrame();
	static JLabel mensagem = new JLabel("Pense em um animal: ");
	static JButton ok = new JButton("OK");
	static No no = new No();

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		janela.setTitle("Animais");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setBounds(280, 250, 235, 110);
		janela.setVisible(true);
		janela.setLayout(null);
		janela.add(mensagem).setBounds(40, 0, 200, 50);
		janela.add(ok).setBounds(70, 40, 70, 20);

		botao(no);

	}

	static void botao(No no) {
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(null, "O Animal que você escolheu vive na Água?");
				if (resposta == JOptionPane.YES_OPTION) {
				String nome = "";
				Tubarao(no, nome);
				} else {
					String nome = "";
					Macaco(no,nome);
				}

			}
		});
	}

	public static void Tubarao(No no, String nome) {

		if (nome.equals("")) {
			nome = "Tubarão";
		} else {
			
			JOptionPane.showConfirmDialog(null, "O animal que você pensou é " + no.valor + "?");
			nome = no.valor1;
		}

		if (no.noEsquerdo != null) {
			Tubarao(no.noEsquerdo, nome);
		} else {
			if (JOptionPane.showConfirmDialog(null, "O Animal que você pensou é " + nome + "?", "Jogo dos Animais",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Acertei de novo!");

			} else {
				
				String caracteristica = JOptionPane.showInputDialog("Qual animal você Pensou?");
				String valor = JOptionPane.showInputDialog("Um(a) " + caracteristica + " é ________, mas um(a) " + nome + " não.");
				No caract = new No();
				caract.valor1 = caracteristica;
				no.noEsquerdo = caract;
				caract.valor = valor;
				
				no.noEsquerdo = caract;
						
			}
		}
	}
		
		public static void Macaco(No no, String nome) {

			if (nome.equals("")) {
				nome = "Macaco";
			} else {
				
				JOptionPane.showConfirmDialog(null, "O animal que você pensou é " + no.valor + "?");
				nome = no.valor1;
			}

			if (no.noDireito != null) {
				Tubarao(no.noDireito, nome);
			} else {
				if (JOptionPane.showConfirmDialog(null, "O Animal que você pensou é " + nome + "?", "Jogo dos Animais",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Acertei de novo!");

				} else {
					
					String caracteristica = JOptionPane.showInputDialog("Qual animal você Pensou?");
					String valor = JOptionPane.showInputDialog("Um(a) " + caracteristica + " é ________, mas um(a) " + nome + " não.");
					No caract = new No();
					caract.valor1 = caracteristica;
					no.noDireito = caract;
					caract.valor = valor;
					
					no.noDireito = caract;
							
				}
			}
	}
}
