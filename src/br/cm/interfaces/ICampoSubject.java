package br.cm.interfaces;

import br.cm.modelo.Campo;
import br.cm.modelo.CampoEvento;

@FunctionalInterface
public interface ICampoSubject {

	public void eventoOcorreu(Campo campo, CampoEvento evento);
}
