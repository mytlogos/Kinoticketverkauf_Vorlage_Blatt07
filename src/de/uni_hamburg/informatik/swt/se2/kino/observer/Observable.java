package de.uni_hamburg.informatik.swt.se2.kino.observer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Lieven Petersen
 *
 * Eine Überklasse fur Klassen die von Observern beobachtet werden sollen.
 */
public abstract class Observable {
	
	private Set<Observer> _observer = new HashSet<>();
	
	/**
	 * mit dieser Methode können sich neue Observer bei dieser Klasse anmelden
	 * @param observer Die Klasse die ueber aenderungen in dieser Klasse informiert werden soll
	 * 
	 * @require observer != null
	 * 
	 * @ensure _observer != null
	 * @ensure _observer.contains(observer)
	 */
	public void registriere(Observer observer)
	{
		assert observer != null : "Vorbedingung verletzt: null";
		
		_observer.add(observer);
	}
	
	/**
	 * Kann nach einer wichtigen aenderung aufgerufen werden um alle observer zu informieren
	 */
	protected void benachrichtigeUeberAenderung()
	{
		for(Observer observer: _observer)
		{
			observer.reagiereAufAenderung(this);
		}
	}
}
