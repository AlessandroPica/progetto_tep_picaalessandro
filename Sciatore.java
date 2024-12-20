import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Sciatore extends Thread {

    private String nome;

    public Sciatore(String nome) {
        this.nome = nome;
    }

    public boolean scendiPista(Semaphore pista, String nomePista) {
        try {
            if (pista.tryAcquire()) {
                System.out.println(nome + " sta scendendo dalla " + nomePista + ". Tempo stimato: " + 3 + " secondi.");
                TimeUnit.SECONDS.sleep(3);
                System.out.println(nome + " ha completato la discesa dalla " + nomePista + ".");
                pista.release();
                return true;
            } else {
                System.out.println(nome + " non può scendere dalla " + nomePista + " perché è piena.");
                return false;
            }
        } catch (InterruptedException e) {
            System.out.println(nome + " interrotto durante la discesa dalla " + nomePista + ".");
            return false;
        }
    }

    public void usaSeggiovia() {
        try {
            ImpiantoSciistico.seggiovia.acquire();
            System.out.println(nome + " sta usando la seggiovia per risalire. Tempo stimato: 3 secondi.");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(nome + " ha completato la risalita con la seggiovia.");

            // Simula la discesa della seggiovia prima di accogliere nuovi sciatori
            System.out.println("La seggiovia sta scendendo dalla montagna. Tempo stimato: 4 secondi.");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("La seggiovia ha completato la discesa dalla montagna ed è pronta ad accogliere nuovi sciatori.");

            ImpiantoSciistico.seggiovia.release();
        } catch (InterruptedException e) {
            System.out.println(nome + " interrotto durante la risalita con la seggiovia.");
        }
    }

}
