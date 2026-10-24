# Neon Chrome (Fabric-Mod)

Cyberpunk-inspirierte Mod für Minecraft Java **26.1.2** mit Fabric. Alle Namen, Texturen und Mechaniken sind eigene Erfindungen.

## Inhalt

| Ding | Was es tut |
|---|---|
| **Chromsplitter** (`chrome_shard`) | Basis-Material. Rezept: Eisenbarren + Redstone + Glowstone-Staub → 2 Splitter |
| **Chrompanzerung** (`chrome_plating`) | Dekorativer Metallblock (9 Splitter). Braucht eine Eisenspitzhacke zum Abbauen |
| **Neonblöcke** (cyan, magenta, gelb) | Leuchten mit Lichtlevel 15. Rezept: Glas + Glowstone-Staub + Farbstoff → 2 Blöcke |
| **Armklinge** (`arm_blade`) | Schwert auf Diamant-Niveau. Rezept: 2 Splitter + Diamant (senkrecht) |
| **Overclock-Injektor** (`overclock_injector`) | Rechtsklick: 15 s **Overclock** (viel schneller laufen und zuschlagen), danach 20 s **Burnout** (langsamer). Einmalig nutzbar |

Die beiden Effekte `overclock` und `burnout` funktionieren auch mit `/effect give @s neon_chrome:overclock`.

## Bauen

Voraussetzung: **JDK 25** (Minecraft 26.1 braucht Java 25).

```
./gradlew build        # Windows: gradlew.bat build
```

Die fertige Mod liegt danach in `build/libs/neon-chrome-1.0.0.jar` (nicht die `-sources.jar`). Sie kommt in den `mods`-Ordner deiner Fabric-Installation, zusammen mit der **Fabric API**.

Zum Testen direkt aus dem Projekt: `./gradlew runClient`

## Hinweise

- In IntelliJ IDEA: Projekt über `build.gradle` öffnen (IDEA 2025.3 oder neuer wegen Java 25).
- Falls Gradle meckert, dass die Version zu alt ist: `./gradlew wrapper --gradle-version latest`.
- Versionen stehen in `gradle.properties`; aktuelle Werte findest du auf https://fabricmc.net/develop.
- Dieses Projekt wurde ohne Compiler-Lauf geschrieben. Wenn der Build einen Fehler meldet, schick mir die Meldung, dann fixe ich es.
