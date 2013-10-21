#Datenpannen-Calculator

Der Datenpannen-Calculator ist ein studentisches Projekt
für das Fach "IT-Sicherheitsmanagement" im Masterstudiengang Informatik
an der Hochschule Zittau/Görlitz.

Ziel ist es, Unternehmen die Möglichkeit zur Kostenabschätzung bei
Datenpannen zu geben. Dazu wird ein Tool entwickelt, welches bestimmte Werte
und Kennzahlen eines Unternehmens als Eingabe entgegen nimmt und daraus berechnet,
welche Kosten bei einer Datenpanne auf das Unternehmen zukommen könnten.

Basis für die Berechnung sind bestimmte Statisische Auswertungen zu Datenpannen der Vergangenheit.

## Technische Informationen

Das Programm wird in Java entwickelt. Als Oberflächen-Technologie kommt [JavaFX](http://docs.oracle.com/javafx/)
zum Einsatz. Zum einfachen Arbeiten mit JavaFX wird das Mini-Framework 
[Afterburner.fx](https://github.com/AdamBien/afterburner.fx) eingesetzt.

Als Build-System wird [Gradle](http://www.gradle.org/) eingegesetzt.

### Initiales Aufsetzen des Projekts:
1. Projekt per Git clonen
2. In der Konsole in das Projekt-Verzeichnis wechseln
3. `gradle create-dirs` ausführen um die Java-Projekt-Struktur anzulegen. Dies ist notwendig, da leere
Verzeichnisse nicht von git getrackt werden. Durch den Befehl werden alle fehlenden leeren Verzeichnisse angelegt.
4. `gradle build` zum Bauen der Anwendung
5. `gradle run` zum Ausführen der Anwendung

### Arbeiten mit Eclipse
Um das Gradle-Projekt mit Eclipse zu bearbeiten gibt es 2 Möglichkeiten:
1. Man installiert eine Erweiterung in Eclipse, die Gradle-Projekte erkennt.
2. Man führt den Befehl `gradle eclipse` aus. Dadurch erzeugt Gradle die notwendigen Eclipse-Projekt-Dateien. Das Projekt kann anschließend ganz normal in Eclipse importiert werden. Wichtig ist: Bei Änderungen der `build.gradle`-Datei, z.B. neue Abhängigkeiten wurden definiert, muss der Befehl erneut ausgeführt werden. Danach muss das Projekt in Eclipse refreshed werden, damit die Änderungen von Eclipse erkannt werden.

### Arbeiten mit IntelliJ Idea

IntelliJ Idea kann von Hause aus mit Gradle-Projekten umgehen. Das Projekt kann also einfach importiert werden.

### Arbeiten mit Netbeans

Netbeans kann per Plugin bereits mit Gradle-Projekten umgehen. Es sind keine weiteren Schritte notwendig.

