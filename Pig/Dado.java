

public class Dado {
    private int valorMaximo;

    public Dado(int valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public int lanzar() {
        return (int) (Math.random() * valorMaximo) + 1;
    }
}