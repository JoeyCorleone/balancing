/**
 * Coding Conventions
 * ------------------
 * UNBEDINGT EINHALTEN!
 * ------------------
 * 
 * 1) UpperCamelCase f�r: Klassen
 *    lowerCamelCase f�r: Funktionen, Variablen, Pakete
 * 
 * 	RICHTIG: 
 * 		Klassenname: HundMitBart
 * 		Variable: int alterVonHund;
 * 	FALSCH:
 * 		Klassenname: hundmitbart
 * 		Variable: int altervonhund;
 * 
 * 2) Leerzeichen nach Kommata
 * 
 * 	RICHTIG: 
 * 		(a, b, c)
 * 	FALSCH:
 * 		(a,b,c)
 * 
 * 3) '{'-Zeichen entweder immer in der Signatur-Zeile ODER immer unter der Signatur-Zeile (Konsistenz!)
 * 		(erste Variante empfohlen!)
 * 
 * 	RICHTIG:
 * 		public int meineFunktion() {
 * 			...
 * 		}
 *
 * 4) Ein Tab einr�cken pro Verschachtelungstiefe (== 1x Tab-Taste pro {}-Block) !
 * 
 * RICHTIG: 
 * 		if (a == b) {
 *			for (...) {
 *				int x = 4;
 *				int y = 3;
 *			}
 *			int z = 6;
 *		} else {
 *			int a = 8;
 *		}
 *
 * FALSCH:
 * 		if (a == b) {
 *		for (...) {
 *		int x = 4;
 *		int y = 3;
 *		}
 *		int z = 6;
 *		}else { int a = 8; }
 *		
 * 5) Je nachdem wie man die geschweiften Klammern setzt, das else passend setzen: (erste Variante empfohlen!)
 * 
 * 		if (a == b) {
 *			...
 *		} else {
 *			...
 *		}
 *		
 *		ODER
 *		
 *		if (a == b)
 *		{
 *			...
 *		}
 *		else 
 *		{
 *			...
 *		}
 *	
 * 6) Kein Leerzeichen vor/nach Klammern
 *  
 * 	RICHTIG:
 * 		(a == b)
 * 	FALSCH:
 * 		( a == b )
 * 
 * 7) Leerzeichen vor/nach zweistelligen Operatoren 
 * 
 * 	RICHTIG:
 * 		(a + b)
 * 	FALSCH:
 * 		(a+b)
 * 
 * 8) Leerzeichen vor/nach den Bedingungen von for/while/if
 * 
 * 	RICHTIG:
 * 		while (x != 0) {
 * 
 * 	FALSCH:
 * 		while(x != 0){
 * 
 * 9) Variablen "sprechende" Namen geben!
 * 
 * 	RICHTIG:
 * 		int alter;
 * 		String nameVonHund;
 * 		String geburtsort;
 * 
 * 	FALSCH:
 * 		int a;
 * 		String nvh;
 * 		String gb;
 * 
 * 10) Sinnvoll kommentieren: 
 * 		Regeln: - So wenig wie m�glich, aber so viel wie n�tig!
 * 			    - Man sollte den Quellcode dank sprechender Namen bereits fl�ssig lesen k�nnen.
 * 			    - Komplexe Zusammenh�nge lassen sich mit Kommentaren darstellen.
 * 
 * 	FALSCH:
 * 		int x = 5; // weist x den Wert 5 zu
 * 		int y = 7; // weist y den Wert 7 zu
 * 		int z = x + y; // berechnet Summe
 * 
 * 11) Aufbau einer Klasse:
 * 		
 * 		public class NAME {
 * 			ATTRIBUTE
 * 			KONSTRUKTOREN
 * 			OPERATIONEN
 * 		} 
 *
 * 12) Variablen so lokal wie m�glich anlegen
 *
 *	RICHTIG:
 *		for (int i = 0; i < 10; i++) {
 *			...
 *		}
 *		
 *	FALSCH:
 *		int i;
 *		for (i = 0; i < 10; i++) {
 *			...
 *		}
 *
 *	13) "Magic numbers" vermeiden!
 */