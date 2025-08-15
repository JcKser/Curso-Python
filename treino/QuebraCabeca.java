public class QuebraCabeca {

    static String quebraCabe(int tamanho, int[][] matriz, char[] letras) {
        boolean[] usados = new boolean[tamanho];
        for (int i = 0; i < tamanho; i++) {
            usados[i] = true;
            String resultado = backtrack(tamanho, matriz, letras, new int[][]{matriz[i]}, new boolean[]{usados[i]}, usados, 1);
            if (resultado != null) return resultado;
            usados[i] = false;
        }
        return "";
    }

    static String backtrack(int tamanho, int[][] matriz, char[] letras, int[][] caminho, boolean[] usadosTemp, boolean[] usados, int nivel) {
        if (nivel == tamanho) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < caminho.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if (matriz[j] == caminho[i]) {
                        sb.append(letras[j]);
                        break;
                    }
                }
            }
            return sb.toString();
        }

        int[] ultima = caminho[nivel - 1];
        for (int i = 0; i < tamanho; i++) {
            if (!usados[i] && ultima[2] == matriz[i][0]) {
                usados[i] = true;

                int[][] novoCaminho = new int[nivel + 1][3];
                System.arraycopy(caminho, 0, novoCaminho, 0, nivel);
                novoCaminho[nivel] = matriz[i];

                String result = backtrack(tamanho, matriz, letras, novoCaminho, usadosTemp, usados, nivel + 1);
                if (result != null) return result;

                usados[i] = false;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] matriz1 = {
            {4, 0, 1},  // A
            {0, 1, 7},  // T
            {3, 2, 5},  // M
            {7, 3, 3}   // E
        };
        char[] letras1 = {'A', 'T', 'M', 'E'};
        System.out.println(quebraCabe(4, matriz1, letras1));  // TEMA

        int[][] matriz2 = {
            {197, 0, 1},    // I
            {0, 1, 399},    // O
            {399, 2, 197}   // B
        };
        char[] letras2 = {'I', 'O', 'B'};
        System.out.println(quebraCabe(3, matriz2, letras2));  // OBI
    }
}