import java.util.Scanner;

public class Jugador {
    private String nombre;
    private int puntaje;
    private Dado dado1;
    private Dado dado2;

    public Jugador(String nombre, Dado dado1, Dado dado2) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.dado1 = dado1;
        this.dado2 = dado2;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void jugarTurno() {
        Scanner scanner = new Scanner(System.in);
        int puntajeTurno = 0;
        boolean continuar = true;

        System.out.println(nombre + " está jugando su turno.");

        while (continuar && puntajeTurno < 20) {
            int valorDado1 = dado1.lanzar();
            int valorDado2 = dado2.lanzar();

            System.out.println(nombre + " lanzó el dado 1 y obtuvo: " + valorDado1);
            System.out.println(nombre + " lanzó el dado 2 y obtuvo: " + valorDado2);

            if (valorDado1 == 1 || valorDado2 == 1) {
                System.out.println(nombre + " obtuvo un 1 en uno de los dados. Pierde los puntos de este turno.");
                puntajeTurno = 0;
                break;
            } else {
                puntajeTurno += valorDado1 + valorDado2;
                System.out.println(nombre + " ha acumulado " + puntajeTurno + " puntos en este turno.");
                System.out.println("¿Desea continuar lanzando los dados? (s/n): ");
                String eleccion = scanner.nextLine().trim().toLowerCase();
                continuar = eleccion.equals("s");
            }
        }

        puntaje += puntajeTurno;
    }
}


