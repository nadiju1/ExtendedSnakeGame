Snake Game Extended
	Software Projekt von Nadine Jung, Kimberly Köhnke und Aylin Alagöz

Steuerung
	Der Spieler bewegt sich mit den Tasten wasd.
		- "w" = eine Zeile hoch 
		- "a" = eine Stelle nach links 
		- "s" = eine Zeile runter
		- "d" = eine Stelle nach rechts 
 
	Die Eingaben werden in der Konsole getätigt.


Spielanleitung 
	Der Spieler muss die Goldstücke einsammeln und dann zur Tür gelangen ohne von der Schlange gefangen zu werden. 
	Auf dem Weg zum Goldstück oder zur Tür gibt es noch einige andere Gegenstände, welche eingesammelt werden können. 
	Es ist nicht notwendig diese Gegenstände einzusammeln um das Spiel zu gewinnen.
	Um zu gewinnen müssen alle Goldstücke eingesammelt werden. 

Grundsätzliche "Gegenstände": 
	- Player = der Spieler, dessen Bewegung durch die Eingabe des Benutzers in der Konsole gesteuert wird. 
	- Snake = die Schlange, die den Spieler jagt. 
	- door = auf dieses Feld muss der Player gelangen, damit das Level beendet wird. 
	- gold = Nur wenn alle Goldstücke eingesammelt wurden, kann das Level beendet werden und das Spiel gewonnen werden. 

Weitere Gegenstände: 
	- SpringBoard = sobald diese Gegenstand eingesammelt wurde, kann der Spieler mehrere Zeilen auf einmal springen. 
	- MagicPotion = ermöglicht dem Spieler Doppelsprünge.  
	- Shield = dieser Gegenstand macht den Spieler resistent gegen einen Schlangenangriff
	- Sword = durch diesen Gegenstand kann der Spieler die Schlange töten. 


Die Klassen 
	- SnakeGameDriver
		Diese Klasse muss ausgeführt werden, um das Spiel zu starten. Die oben genannten Gegenstände werden hier deklariert. 
		Die Methoden der Klassen Player, Snake und BoardLevel werden genutzt um das Spielfeld zu kreieren und es in der Konsole ausgeben zu können, sowie die 
		Bewegung des Spielers und der Schlange einfügen zu können. 

	- Player
		Die notwendigen Variablen und Methoden für den Spieler werden hier deklariert.

	- Snake 
		Die notwendigen Variablen und Methoden für die Schlange werden deklariert. Die Bewegung der Schlange wird hier festgelegt. 

	- BoardLevel
		Die Methode um das Spielfeld zu zeichnen wird hier festgelegt. Je nach Level sieht das Spielfeld anders aus. Es vergrößert sich mit jedem neuen Level. 


Sonstiges
	Die JavaDoc für die Klassen SnakeGameDriver, Snake, Player und BoardLevel ist zu finden unter ExtendedSnakeGame\javadoc\game
	Die jar ist unter ExtendedSnakeGame\out\artifacts\ExtendedSnakeGame_jar zu finden.