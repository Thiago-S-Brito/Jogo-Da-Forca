import java.util.Scanner;
import java.util.Random;

public class JogoDaForca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] palavras = {"programacao", "java", "computador", "desenvolvimento", "inteligencia", "hardware", "gabinete", "monitor", "codificação", "mousepad", "teclado",
        "webcam", "periferico", "headset", "ventoinha", "software", "controle", "arquivo", "aplicativo", "navegador", "compactar", "descompactar", "minimizar", "maximizar",
        "notificação", "console", "digitalização", "camera", "palpite", "status", "facebook", "bateria", "carregador", "suporte", "tecnico", "integração", "hábitos", "transmição"
        "fragmentação"};

        String palavraSecreta = palavras[random.nextInt(palavras.length)];
        int tentativasMaximas = 6;

        char[] letrasAdivinhadas = new char[palavraSecreta.length()];
        for (int i = 0; i < letrasAdivinhadas.length; i++) {
            letrasAdivinhadas[i] = '_';
        }

        int tentativas = 0;

        while (tentativas < tentativasMaximas) {
            System.out.println("Palavra: " + new String(letrasAdivinhadas));
            System.out.println("Tentativas restantes: " + (tentativasMaximas - tentativas));
            System.out.print("Digite uma letra: ");
            char palpite = scanner.next().charAt(0);

            boolean letraAdivinhada = false;
            for (int i = 0; i < palavraSecreta.length(); i++) {
                if (palavraSecreta.charAt(i) == palpite) {
                    letrasAdivinhadas[i] = palpite;
                    letraAdivinhada = true;
                }
            }

            if (!letraAdivinhada) {
                tentativas++;
                System.out.println("Letra incorreta. Tente novamente.");
            }

            boolean todasLetrasAdivinhadas = true;
            for (char letra : letrasAdivinhadas) {
                if (letra == '_') {
                    todasLetrasAdivinhadas = false;
                    break;
                }
            }

            if (todasLetrasAdivinhadas) {
                System.out.println("Parabéns! Você adivinhou a palavra: " + palavraSecreta);
                break;
            }
        }

        if (tentativas == tentativasMaximas) {
            System.out.println("Você perdeu. A palavra era: " + palavraSecreta);
        }

        scanner.close();
    }
}