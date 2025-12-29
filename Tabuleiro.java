import java.util.Random;

public class Tabuleiro {
    private char[][] Matriz;
    private int Tamanho = 5;
    private int NaviosRestantes;


    public Tabuleiro(){
        Matriz = new char[Tamanho][Tamanho];
        NaviosRestantes = 3; //3 navios definidos para o game
        InicializarTabuleiro();
        PosicionarNaviosAleatoriamente();
    }

    private void InicializarTabuleiro(){ //inicializar tabuleiro com ~ como agua
        for(int i = 0; i < Tamanho; i++){
            for(int j = 0; j < Tamanho; j++){
                Matriz[i][j] = '~'; 
            }
        }
    }

    private void PosicionarNaviosAleatoriamente(){
        Random random = new Random();
        int Posicionados = 0;

        while(Posicionados < NaviosRestantes){
            int Linha = random.nextInt(Tamanho);
            int Coluna = random.nextInt(Tamanho);

            if(Matriz[Linha][Coluna] == '~'){
                Matriz[Linha][Coluna] = 'N'; //naviozin
                Posicionados++;
            }
        }
    }

    public void Exibir(boolean EsconderNavios){
        System.out.println("\n 0 1 2 3 4");
        for(int i = 0; i < Tamanho; i++){
            System.out.print(i + " ");
            for(int j = 0; j < Tamanho; j++){
                char Atual = Matriz[i][j];
                if(EsconderNavios && Atual == 'N'){
                    System.out.print("~ ");

                }else{
                    System.out.print(Atual + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean DarTiro(int Linha, int Coluna){
        if(Matriz[Linha][Coluna] == 'N'){
            Matriz[Linha][Coluna] = 'X';
            NaviosRestantes--;

            System.out.println("Acertou um naviozin!");
            return true;
        }
        else if(Matriz[Linha][Coluna] == '~'){
            Matriz[Linha][Coluna] = 'O'; //errar o tiro
            System.out.println("Tiro na agua!");
        }else{
            System.out.println("Já atingido, escolha outro");

        }
        return false;
    }




    public int getNaviosRestantes(){
        return NaviosRestantes;
    }

    public int getTamanho(){
        return Tamanho;
    }
}
