package de.uni_hamburg.informatik.swt.se2.kino.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Lieven Petersen
 *
 * Eine Überklasse fur Klassen die von Observern beobachtet werden sollen.
 */

public abstract class Observable {
	
	private List<Observer> _observer;
	
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
		//falls die observer-liste nicht initialisiert ist (so spart man sich den konstruktor)
		if (_observer == null)
			_observer = new LinkedList<Observer>();
		
		if (observer != null)
			_observer.add(observer);
	}
	
	/**
	 * Kann nach einer wichtigen aenderung aufgerufen werden um alle observer zu informieren
	 * 
	 * @require _observer != null
	 * 
	 */
	protected void benachrichtigeUeberAenderung()
	{
		if (_observer != null)
		{
			for(Observer observer: _observer)
			{
				observer.reagiereAufAenderung(this);
			}
		}
	}
}
