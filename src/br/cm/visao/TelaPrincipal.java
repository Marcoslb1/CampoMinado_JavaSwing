package br.cm.visao;

import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.JFrame;

import br.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame{

	public TelaPrincipal() {
		Tabuleiro tabuleiro = new Tabuleiro(16, 30, 50);
		PainelTabuleiro painelTabuleiro = new PainelTabuleiro(tabuleiro);
		
		add(painelTabuleiro);
		setSize(690, 438);
		setFont(new Font("System", Font.PLAIN, 14));
		Font f = getFont();
		FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("Hello Center");
        int y = fm.stringWidth(" ");
        int z = getWidth() / 2 - (x / 2);
        int w = z / y;
        String pad = "";
		
        pad = String.format("%" + w + "s", pad);
		setTitle(pad+"CAMPO MINADO");
		
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		
		new TelaPrincipal();
	}
}
