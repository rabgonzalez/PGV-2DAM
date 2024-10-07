# Juego cazadores
## Personaje
### (nombre, posición, mapa)
- sincronizado Moverse(){ Random(0, array.length-1) }
> Se puede reutilizar como el spawn de los monstruos.

## Cazador extends Personaje
### (contadorMuertes)
- sincronizado Matar(){ Random(1,10) > 7 ? false : true}
> Cuando un cazador y un monstruo estén en la misma celda.

## Monstruo extends Personaje
### (tiempoVida, muerto?)

## Mapa
### (Personaje[][])

## Main
- reducirTiempoMonstruo //Si no lo han cazado.
- comprobarPosiciones //Que no haya 2 monstruos/cazadores en la misma posición.
- gestionarEnfrentamientos //Si un cazador gana, el monstruo muere y suma contador.
