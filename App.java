import java.util.Scanner;

public class App{
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tabuleiro Jogo = new Tabuleiro();

        System.out.println("--- BATALHA NAVAL ---");

        while (Jogo.getNaviosRestantes() > 0) {
            Jogo.Exibir(true);

            System.out.println("\n Navios Restantes: " + Jogo.getNaviosRestantes());

            System.out.print("Digite a Linha (0-4): ");
            int Linha = scanner.nextInt();


            System.out.print("Digite a Coluna (0-4): ");
            int Coluna = scanner.nextInt();


            if(Linha < 0 || Linha >= Jogo.getTamanho() || Coluna < 0 || Coluna >= Jogo.getTamanho() ){
                System.out.println("Coordenadas inválidas! Tente novamente.");
                continue;
            }

            Jogo.DarTiro(Linha, Coluna);
        }

        System.out.println("Navios Afundados! Você ganhou o jogo!");
        Jogo.Exibir(false);
        scanner.close();    
   }
}