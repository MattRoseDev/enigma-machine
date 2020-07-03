# Enigma Machine

This is an Enigma machine cryptographer.

# Usage
Generate your rotors with this command.
```scala
$: scala rotor.scala generate
```

You can encrypt or decrypt your text with this command.
```scala
$: scala main.scala "to be, or not to be" // output: v895#|{8iwx%ng6455h
```

```scala
$: scala main.scala "v895#|{8iwx%ng6455h" // output: to be, or not to be
```
