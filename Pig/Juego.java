import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private final int PUNTAJE_GANADOR = 100;

    public Juego(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void jugar() {
        boolean juegoTerminado = false;
        Jugador ganador = null;

        while (!juegoTerminado) {
            for (Jugador jugador : jugadores) {
                jugador.jugarTurno();
                System.out.println(jugador.getNombre() + " tiene un puntaje total de " + jugador.getPuntaje() + ".");

                if (jugador.getPuntaje() >= PUNTAJE_GANADOR) {
                    juegoTerminado = true;
                    ganador = jugador;
                    break;
                }
            }
        }

        System.out.println("¡" + ganador.getNombre() + " ha ganado el juego!");
    }

    public static void main(String[] args) {
        Dado dado1 = new Dado(6);
        Dado dado2 = new Dado(6);

        Jugador jugador1 = new Jugador("Jugador 1", dado1, dado2);
        Jugador jugador2 = new Jugador("Jugador 2", dado1, dado2);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Juego juego = new Juego(jugadores);
        juego.jugar();
    }
}

