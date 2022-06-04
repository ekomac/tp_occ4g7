package pseudo;

import java.util.Scanner;

class Pseudo {

    // imprimir: imprime una linea de .asciz
    private static void imprimir(int etiquetaDireccionMemoria, int tamanoCadena) {
        String direcciones = "direcciones de memoria";
        String sub = direcciones.substring(
                etiquetaDireccionMemoria,
                etiquetaDireccionMemoria + tamanoCadena);
        System.out.println(sub);
    }

    /* MATI */
    // imprimir mapa: ciclo que llama a imprimir
    private static void imprimirMapa() {
        // .data
        // matriz: .ascii "0123...51"
        // .ascii "0123...51"
        // ldr r1, =matriz

        int tamanoCadena = 52;
        int dirMem = 0; // ldr r1, =matriz
        int contador = 0;
        int cantidadFilas = 14;
        while (contador < cantidadFilas) {
            imprimir(dirMem, tamanoCadena);
            contador++;
            dirMem += 52;
        }
    }

    /* BRA */
    private static void imprimirAciertos() {
        /*
         * .data
         * tamanoCadena: .byte 52
         * matrizAciertos: .ascii "0123...51" // (x5)
         * .ascii "0123...51"
         */
        int tamanoCadena = 52; // ldr r2, [tamanoCadena]
        int dirMem = 0; // ldr r1, =matrizAciertos
        int contador = 0;
        int cantidadFilas = 5;
        while (contador < cantidadFilas) {
            imprimir(dirMem, tamanoCadena);
            contador++;
            dirMem += 52;
        }
    }

    /* ESTA HECHA EN CLASE */
    int tamanoCadena(int dirMem) {
        return 0;
    }

    /* JUAN */
    // imprimir feedback
    void imprimirFeedback() {
        /*
         * .data
         * feedback: .asciz "Quedan 5 letras por adivinar."
         */
        int dirMem = 0; // ldr r1, =feedback
        int tamanoCadena = tamanoCadena(dirMem);
        imprimir(dirMem, tamanoCadena);
    }

    /**
     * MATI
     * 
     * Lo que está en ascii lo retorna en un numero
     */
    int convertirANum(char caracter) {
        return caracter - 30;
    }

    /* BRA */
    int escanearOpcion() {
        Scanner sc = new Scanner("Ingresá 1 para arriesgar letra, 2 para arriesgar palabra");
        char input = sc.next().toCharArray()[0];
        sc.close();
        int num = convertirANum(input);
        return num;
    }

    /* JUAN */
    char escanearLetra() {
        // .data
        // escanerLetra: .byte "a"
        Scanner sc = new Scanner("Ingrese una letra");
        char input = sc.next().toCharArray()[0];
        int dirMem = 0; // ldrb r1, =escanerLetra
        int tamanoEscanear = 1;
        sc.close();
        return input;
    }

    void escanearPalabra() {
        Scanner sc = new Scanner("Ingresá 1 para arriesgar letras, 2 para arriesgar palabra");
        char input = sc.next().toCharArray()[0];
        sc.close();
        // return input;
    }

    public static void main(String[] args) {
        System.out.println("Hola");
    }

    public static boolean largoCadena(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }
}