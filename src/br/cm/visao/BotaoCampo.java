package br.cm.visao;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import br.cm.interfaces.ICampoSubject;
import br.cm.interfaces.IMouse;
import br.cm.modelo.Campo;
import br.cm.modelo.CampoEvento;

@SuppressWarnings("serial")
public class BotaoCampo extends JButton implements ICampoSubject, IMouse {

	private final Color BG_PADRAO = new Color(184, 184, 184);
	private final Color BG_MARCADO = new Color(8, 179, 247);
	private final Color BG_EXPLOSAO = new Color(189, 66, 68);
	private final Color TEXTO_VERDE = new Color(0, 100, 0);
	
	private Campo campo;
	
	public BotaoCampo(Campo campo) {
		this.campo = campo;
		setBackground(BG_PADRAO);
		setOpaque(true);
		setBorder(BorderFactory.createBevelBorder(0));
		
		addMouseListener(this);
		campo.registrarObservador(this);
	}

	@Override
	public void eventoOcorreu(Campo campo, CampoEvento evento) {
		switch(evento) {
		case ABRIR: 
			aplicarEstiloAbrir();
			break;
			
		case MARCAR: 
			aplicarEstiloMarcar();
			break;
			
		case EXPLODIR: 
			aplicarEstiloExplodir();
			break;
			
		default:
			aplicarEstiloPadrao();
		}
		
		SwingUtilities.invokeLater(()-> {
			repaint();
			validate();
		});
	}

	private void aplicarEstiloPadrao() {
		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createBevelBorder(0));
		setText("");
	}

	private void aplicarEstiloExplodir() {
		setBackground(BG_PADRAO);
		setForeground(Color.white);
		setText("X");
	}

	private void aplicarEstiloMarcar() {
		setBackground(BG_PADRAO);
		setForeground(Color.black);
		setText("M");
		
	}

	private void aplicarEstiloAbrir() {
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		if(campo.isMinado()) {
			setBackground(BG_EXPLOSAO);
			return;
		}
		setBackground(BG_PADRAO);
		
		switch (campo.minasNaVizinhanca()) {
		case 1: {
			 setForeground(TEXTO_VERDE);
			 break;
		}
		case 2: {
			 setForeground(Color.BLUE);
			 break;
		}
		case 3: {
			 setForeground(Color.YELLOW);
			 break;
		}
		
		case 4:
		case 5:
		case 6:
		
		default:
			setForeground(Color.BLACK);
		}
		
		String valor = !campo.vizinhancaSegura() ? campo.minasNaVizinhanca() + "" : "";
		setText(valor);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == 1) {
			campo.abrir();
		}else {
			campo.alternarMarcacao();
		}
	}


}
