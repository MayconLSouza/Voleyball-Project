/*
    Nome do programa: Sistema_Volei
    Classe: Principal
    Objetivo: Realizar uma partida de vôlei e coletar dados para análise técnica.
    Nomes dos Programadores: Maycon L.M. Souza e Otávio Augusto 
    Data de atualização : 09/07/2023 
*/

//=========================================================================================
// Biblioteca
import java.io.IOException;             // Biblioteca para tratamento de exceções de entrada e saída de dados
import javax.swing.JOptionPane;         // Biblioteca para interface gráfica de usuário (GUI)
//=========================================================================================

//MainCode

public class MenuPrincipal {

    public static void main(String args[]) throws IOException {
        
        //=================================================================================
        // Declaração de Classes/Objetos/Variáveis
        Time[] time = new Time[2];                                          // Array para armazenar os objetos Time (atributos do time em jogo)
        Partida[] partida = new Partida[1];                                 // Array para armazenar os objetos Partida (resultado/requisitos)
        int[][] set = new int [2][5];                                       // Matriz para armazenar o placar dos sets jogados
        ConfiguracoesPartida configuracoes = new ConfiguracoesPartida();    // Objeto para identificar a classe Configurações de Partida, na qual se configura as regras da partida
        RealizarJogo jogo = new RealizarJogo();                             // Objeto para identificar a classe Realização do Jogo, na qual se realiza a partida de vôlei de acordo com as regras oficiais
        Leitura leitura = new Leitura();                                    // Objeto para identificar a classe Leitura, na qual se lê uma partida de vôlei já realizada
        Gravacao gravar = new Gravacao();                                   // Objeto para identificar a classe Gravação, na qual se realiza o salvamento de dados de uma partida em um arquivo txt
        ConsultarRegras regras = new ConsultarRegras();                     // Objeto para identificar a classe de Consulta das Regras, na qual se confere o manual de jogo oficial de vôlei 
        Estatistica estatistica = new Estatistica();                        // Objeto para identificar a classe de Exibição das Estatísticas, na qual mostra ao usuário os resultados de uma partida de vôlei
        int opcaoPrincipal = 0;                                             // Variável para identificar a opção selecionada no menu principal
        
        //=================================================================================     
        // Limpeza de Objeto(Garantir que não haja sujeira ao iniciar o código)
        for (int contador = 0; contador < 2; contador++) {
            time[contador] = new Time(0, 0, "");
        }

        for (int contador = 0; contador < 1; contador++) {
            partida[contador] = new Partida(0,0,0,"","");
        }
        
        //=================================================================================
        // Iniciando o placar zerado
        for (int linha = 0; linha < 2; linha++){
            for( int coluna = 0; coluna < 5; coluna++){
                set[linha][coluna] = 0;
            }
        }
        
        //=================================================================================
        //Menu Principal
        while (opcaoPrincipal != 9) {
            opcaoPrincipal = exibirMenuPrincipal();
            switch (opcaoPrincipal) {
                case 1 -> {
                    configuracoes.ConfigurarPartida(time, partida);
                    JOptionPane.showMessageDialog(null, "A partida irá começar.","Bola em jogo",JOptionPane.INFORMATION_MESSAGE);
                    jogo.IniciarPartida(time, partida, set);
                    JOptionPane.showMessageDialog(null, "Fim da partida.","Apito final",JOptionPane.INFORMATION_MESSAGE); 
                    gravar.GravarPartida(time,partida,set);
                }
                case 2 -> {
                    leitura.LerPartida(time, partida, set);
                }
                case 3 -> {
                    estatistica.Estatisticas(time, partida, set);
                    JOptionPane.showMessageDialog(null, "Consulta de estatísticas de jogo encerrada. Retornando ao menu principal.","Consulta encerrada",JOptionPane.INFORMATION_MESSAGE);
                }
                case 4 -> {
                    regras.RegrasJogoVolei();
                    JOptionPane.showMessageDialog(null,"Consulta de regras de jogo encerrada. Retornando ao menu principal.","Consulta encerrada",JOptionPane.INFORMATION_MESSAGE);
                }
                case 9 -> {
                    JOptionPane.showMessageDialog(null, "Obrigado por utilizar o nosso software de vôlei, espero que tenha se divertido. Até o próximo saque.","Fim do programa",JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                default -> JOptionPane.showMessageDialog(null, "Por favor, digite novamente uma das opções a seguir.","OPÇÃO INVÁLIDA!!!",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    private static int exibirMenuPrincipal(){
        
        //Interface Menu
        String menuPrincipal = """
                      Software de Vôlei
                      ----------------------------------------------------------------
                      Escolha uma das opções a seguir
                      ----------------------------------------------------------------
                      1 - Iniciar partida
                      2 - Ler partida
                      3 - Exibir estatísticas
                      4 - Consultar regras
                      9 - Finalizar
                      ----------------------------------------------------------------
                      """; 
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal));
        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite uma opção válida.", "OPÇÃO INVÁLIDA!!!",JOptionPane.INFORMATION_MESSAGE);
            return exibirMenuPrincipal();           // Chamada recursiva para exibir o menu novamente
        }
    }
    
}


