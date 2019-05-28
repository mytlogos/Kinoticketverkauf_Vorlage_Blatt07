package de.uni_hamburg.informatik.swt.se2.kino.observer;

public interface Observer {
	
	/**
	 * wird aufgerufen, falls in einer beobachteten klasse etwas wichtiges passiert
	 * @param obj Objekt der beobachteten Klasse
	 */
	void reagiereAufAenderung(Observable obj);
	
}
