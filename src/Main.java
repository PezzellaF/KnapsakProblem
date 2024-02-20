import java.util.Arrays;

public class Main {

    // Funzione per risolvere il problema del knapsack
    public static int[] riempimentoZaino(int somma) {
        // Creazione del vettore di oggetti casuali
        int[] v = new int[somma];
        for (int i = 0; i < somma; i++) {
            // Numeri casuali da 1 a somma/2
            v[i] = (int) (Math.random() * (somma / 2 - 1)) + 1;
        }

        // Ordina il vettore in ordine crescente
        Arrays.sort(v);

        // Somma massima iniziale impostata a 0
        int sommaMassima = 0;
        // Conteggio del numero massimo di addendi
        int numAddendiMassimi = 0;
        // Indice per tracciare la soluzione corrente
        int indiceSoluzione = 0;

        // Ciclo per generare tutte le combinazioni di addendi
        for (int i = 0; i < somma; i++) {
            int sommaCorrente = v[i];
            int numAddendiCorrente = 1;

            // Controlla le combinazioni di addendi
            for (int j = i + 1; j < somma; j++) {
                if (sommaCorrente + v[j] <= somma) {
                    sommaCorrente += v[j];
                    numAddendiCorrente++;
                } else {
                    break;
                }
            }

            // Se la somma corrente è maggiore della somma massima trovata finora,
            // o se la somma è uguale ma ha più addendi, aggiorna la soluzione
            if (sommaCorrente > sommaMassima || (sommaCorrente == sommaMassima && numAddendiCorrente > numAddendiMassimi)) {
                sommaMassima = sommaCorrente;
                numAddendiMassimi = numAddendiCorrente;
                indiceSoluzione = i;
            }
        }

        // Creazione dell'array finale della soluzione
        int[] soluzione = new int[numAddendiMassimi + 1];
        soluzione[0] = sommaMassima;
        for (int i = 0; i < numAddendiMassimi; i++) {
            soluzione[i + 1] = v[indiceSoluzione + i];
        }

        return soluzione;
    }

    // Funzione principale per testare il problema
    public static void main(String[] args) {
        int somma = 20;
        int[] soluzione = riempimentoZaino(somma);

        // Stampa la soluzione
        System.out.println("Somma massima: " + soluzione[0]);
        System.out.println("Numero di addendi: " + (soluzione.length - 1));
        System.out.println("Elementi: " + Arrays.toString(Arrays.copyOfRange(soluzione, 1, soluzione.length)));
    }
}
