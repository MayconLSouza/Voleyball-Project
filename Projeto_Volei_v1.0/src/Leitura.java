/*
    Nome do programa: Sistema_Volei
    Classe: Leitura
    Objetivo: Realizar a leitura de dados de uma partida.
    Nomes dos Programadores: Maycon L.M. Souza e Otávio Augusto 
    Data de atualização:  08/07/2023
*/
//=========================================================================================
// Biblioteca
import java.io.*;                       // Biblioteca para entrada e saída de dados
import javax.swing.*;                   // Biblioteca para janela de interação
//=========================================================================================

public class Leitura { 
    
   boolean fim = false;             // variável para caso o usuárioo deseje encerrar a leitura
   boolean erro = false;            // variável para caso ocorra algum erro durante a realização da leitura
   File PastaData;                  // variável referente a pasta da data em que a partida foi realizada
   String NomePastaData;            // variável referente ao nome da pasta da data em que a partida a ser lida foi realizada
   String CaminhoPastaData;         // variável referente ao caminho que se deve seguir para acessar a pasta da data em que a partida foi realizada
   File Arquivo;                    // variável referente ao arquivo que deve ser consultado
   String NomeArquivo;              // variável referente ao nome do arquivo em qu estão gravados os dados a serem consultados
   String CaminhoArquivo;           // variável referente ao caminho que se deve seguir para acessar o arquivo 
   String MenuLeitura = """
                         Gostaria de realizar nova leitura de partida? 
                         ----------------------------------------------------------------
                         1 - Sim
                         2 - Não
                         ----------------------------------------------------------------
                         """;
   
    
   void LerPartida(Time[] time, Partida[] partida, int[][] set) throws IOException{
       
       // módulo que verifica se há partidas gravadas para leitura
       VerificarPartidas();
       if(erro == true){
           JOptionPane.showMessageDialog(null,"Não foi encontrado nenhuma partida gravada para consulta. Não será possível realizar a leitura. Retornando ao menu principal.","NÃO FOI POSSÍVEL REALIZAR LEITURA",JOptionPane.ERROR_MESSAGE);
           return;
       }
       
       // módulo que trata da pasta da data em que a partida foi realizada
       PastaData();
       if (fim == true){
           JOptionPane.showMessageDialog(null,"Fim de leitura de partida. Retornando ao Menu Principal","LEITURA NÃO REALIZADA",JOptionPane.ERROR_MESSAGE);
           return;
       }
       
       // módulo que trata do arquivo em que estão gravados os dados a serem lidos
       Arquivo();
       if (fim == true){
           JOptionPane.showMessageDialog(null,"Fim de leitura de partida. Retornando ao Menu Principal","LEITURA NÃO REALIZADA",JOptionPane.ERROR_MESSAGE);
           return;
       }      
       
       // módulo que realizará a leitura dos dados no arquivo informado pelo usuário
       LerArquivo(time, partida, set);
       
       // mensagem de leitura concluída
       JOptionPane.showMessageDialog(null,"Leitura realizada com sucesso. Os dados já estão disponíveis para consulta. Acesse-os através da opção 3 - 'Exibir estatísticas' do menu principal.\nRetornando ao menu principal.","LEITURA CONCLUÍDA",JOptionPane.INFORMATION_MESSAGE);
   }
   
   void VerificarPartidas(){
       
       // Cria um objeto File que representa o diretório (pasta) chamado "Partidas"
        File PastaPartidas = new File("Partidas"); 
        
        // Verifica se existe partidas já realizadas para serem lidas
        if (!PastaPartidas.exists()) {
            erro = true;
        }
   }
   
   void PastaData(){
       
       //Input de dados, data em que a partida que o usuário deseja consultar foi realizada
       NomePastaData = JOptionPane.showInputDialog("Digite a data em que foi realizada a partida que deseja consultar no formato DD-MM-AAAA.");
       
       // variável referente ao caminho para se localizar a pasta da data em que a partida a ser lida foi realizada
       CaminhoPastaData = "Partidas" + File.separator + NomePastaData;
       
       // Cria a variável do tipo arquivo PastaData através do nome inserido pelo usuário
       PastaData = new File(CaminhoPastaData);
       
       // módulo que verifica se a pasta informada realmente existe.
       VerificarPastaData(PastaData);
       
   }
   
   void VerificarPastaData(File PastaData){
       int OpcaoData = 0;   // variável de opção para verificar se usuário deseja realziar nova consulta
       
       // Data inválida
       if (!PastaData.exists()) {
           JOptionPane.showMessageDialog(null, "Data de partida inválida. Verifique se realemnte ocorreu uma partida nesta data.", "DATA NÃO ENCONTRADA", JOptionPane.ERROR_MESSAGE);
           while((OpcaoData != 1) && (OpcaoData != 2)){
                OpcaoData = Integer.parseInt(JOptionPane.showInputDialog(MenuLeitura));
                switch(OpcaoData){
                    case 1 -> {
                        NomePastaData = JOptionPane.showInputDialog("Digite a data em que foi realizada a partida que deseja consultar no formato DD-MM-AAAA.");
                        VerificarPastaData(PastaData);
                    }
                    case 2 -> {
                        fim = true;
                        return;
                    }
                    default -> JOptionPane.showMessageDialog(null, "Por favor digite novamente uma das opções a seguir.","OPÇÃO INVÁLIDA!!!",JOptionPane.INFORMATION_MESSAGE);
                }    
           }
       }   
   }
   
   void Arquivo(){
       
       //Input de dados, nome do arquivo em que estão gravados os dados a serem consultados
       NomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo da partida que deseja realizar a consulta.");
       NomeArquivo = NomeArquivo + ".txt";
       
       // variável referente ao caminho para se localizar o arquivo a ser consultado
       CaminhoArquivo = PastaData.getAbsolutePath() + File.separator + NomeArquivo;
       
       // Cria a variável do tipo arquivo PastaData através do nome inserido pelo usuário
       Arquivo = new File(CaminhoArquivo);
       
       // módulo que verifica se o arquivo informado realmente existe.
       VerificarArquivo(Arquivo);
       
   }
   
   void VerificarArquivo(File Arquivo){
       int OpcaoArquivo = 0;   // variável de opção para verificar se usuário deseja realziar nova consulta
       
       // Nome de arquivo inválido
       if (!Arquivo.exists()) {
           JOptionPane.showMessageDialog(null, "Nome de arquivo inválido. Verifique se o nome do arquivo inserido está correto.", "ARQUIVO NÃO ENCONTRADO", JOptionPane.ERROR_MESSAGE);
           while((OpcaoArquivo != 1) && (OpcaoArquivo != 2)){
                OpcaoArquivo = Integer.parseInt(JOptionPane.showInputDialog(MenuLeitura));
                switch(OpcaoArquivo){
                    case 1 -> {
                        NomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo da partida que deseja realizar a consulta.");
                        NomeArquivo = NomeArquivo + ".txt";
                        VerificarArquivo(Arquivo);
                    }
                    case 2 -> {
                        fim = true;
                        return;
                    }
                    default -> JOptionPane.showMessageDialog(null, "Por favor digite novamente uma das opções a seguir.","OPÇÃO INVÁLIDA!!!",JOptionPane.INFORMATION_MESSAGE);
                }    
           }
       }   
   }
   
   void LerArquivo(Time[] time, Partida[] partida, int[][] set) throws IOException {
       
       BufferedReader ler = new BufferedReader(new FileReader(CaminhoArquivo));
       
       for(int contador = 0; contador < 2; contador++){
            time[contador].Nome = ler.readLine();
            time[contador].Set = Integer.parseInt(ler.readLine());
        }

        partida[0].Vencedor = ler.readLine();
        partida[0].Perdedor = ler.readLine();
        
        for (int NomeTime = 0; NomeTime < 2; NomeTime++){
            for( int NumeroSet = 0; NumeroSet < 5; NumeroSet++){
                set[NomeTime][NumeroSet] = Integer.parseInt(ler.readLine());
            }
        }
        
        // fechando o arquivo já lido
        ler.close();
   }
   
   
}
