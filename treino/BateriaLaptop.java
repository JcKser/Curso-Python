
public class BateriaLaptop {
    
    public static int getBattery(int[] eventos) {
        int bateria = 50;

        for (int evento : eventos) {
            bateria += evento;

            // Limita a bateria entre 0 e 100
            if (bateria > 100) {
                bateria = 100;
            } else if (bateria < 0) {
                bateria = 0;
            }
        }

        return bateria;
    }

    public static void main(String[] args) {
        // Exemplo de teste
        int[] eventos = {10, -20, 61, -15};
        int resultado = getBattery(eventos);
        System.out.println("Bateria final: " + resultado + "%");
    }
}