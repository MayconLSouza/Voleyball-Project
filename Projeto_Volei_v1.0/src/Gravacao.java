/*
    Nome do programa: Sistema_Volei
    Classe: Gravação
    Objetivo: Realizar a gravação de dados de uma partida.
    Nomes dos Programadores: Maycon L.M. Souza e Otávio Augusto 
    Data de atualização:  09/07/2023
*/
import java.io.*;           // Biblioteca para entrada e saída de dados
import java.time.*;         // Biblioteca para lidar com operações relacionadas a datas, horários e manipulação de tempo.
import java.time.format.*;  // Biblioteca para lidar com formatação e análise de datas, horários e intervalos de tempo. 
import javax.swing.*;       // Biblioteca para janela de interação

public class Gravacao {
    
    boolean erro = false;       // variável para caso ocorra algum erro na criação de pastas onde o arquivo será salvo
    File PastaData;             // variável referente a pasta criada da data em que o jogo foi realizado
    String NomeArquivoCriado;   // variável referente ao nome do arquivo que será preenchido com os dados da partida
    String CaminhoArquivo;      // variável referente ao caminho que se deve seguir para acessar o arquivo criado.
    
    void GravarPartida(Time[] time, Partida[] partida, int[][] set) throws IOException {
        String MenuGravar = """
                      Gostaria de gravar os resultados desta partida? 
                      ----------------------------------------------------------------
                      1 - Sim
                      2 - Não
                      ----------------------------------------------------------------
                      """;
        int OpcaoGravar = 0;
        while((OpcaoGravar != 1) && (OpcaoGravar != 2)){
            OpcaoGravar = Integer.parseInt(JOptionPane.showInputDialog(MenuGravar));
            switch(OpcaoGravar){
                case 1 -> {
                    CriarPasta();
                    if (erro == true){
                        return;
                    }
                    CriarArquivo();
                    if (erro == true){
                        return;
                    }
                    PreencherArquivo(time,partida,set);
                    JOptionPane.showMessageDialog(null, "Salvamento concluído com sucesso. Você pode acessar os dados futuramente através da opção 2 do menu principal 'Ler partida'. Retornando ao menu principal.","GRAVAÇÃO REALIZADA",JOptionPane.INFORMATION_MESSAGE); 
                }
                case 2 -> {
                    JOptionPane.showMessageDialog(null, "Você perderá os dados dessa partida após o encerramento do programa. Retornando ao menu principal.","GRAVAÇÃO NÃO REALIZADA",JOptionPane.INFORMATION_MESSAGE);
                }
                default -> JOptionPane.showMessageDialog(null, "Por favor digite novamente uma das opções a seguir.","OPÇÃO INVÁLIDA!!!",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    void CriarPasta(){
        
        // Cria um objeto File que representa o diretório (pasta) chamado "Partidas"
        File PastaPartidas = new File("Partidas"); 
        
        // Verifica se a pasta "Partidas" já existe, se não existir irá criar
        if (!PastaPartidas.exists()) {
            if (PastaPartidas.mkdir()) {
                System.out.println("Pasta 'Partidas' criada com sucesso.");
            } 
            else {
                JOptionPane.showMessageDialog(null,"Erro ao tentar criar a pasta Partidas para salvar este jogo. Não será possível salvá-lo.","ERRO DE SALVAMENTO",JOptionPane.INFORMATION_MESSAGE);
                erro = true;
                return;
            }
        }
        
        // Obtém a data atual
        LocalDate DataAtual = LocalDate.now();
        
        // Formata a data no formato desejado
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String DataFormatada = DataAtual.format(formatador);
                        
        // Cria o nome da pasta da partida
        String NomePasta = DataFormatada;
        
        // Cria um objeto File que representa o diretório (pasta) da data em que a partida foi realizada
        PastaData = new File(PastaPartidas,NomePasta);
        
        // Verifica se a pasta da data em que a partida foi realizada já existe, se não existir irá criar
        if (!PastaData.exists()) {
            if (PastaData.mkdir()) {
                System.out.println("Pasta da data de quando o jogo foi realizado foi criada com sucesso: " + NomePasta);
            } 
            else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar criar a pasta "+NomePasta+" para salvar este jogo. Não será possível salvá-lo.", "ERRO DE SALVAMENTO", JOptionPane.INFORMATION_MESSAGE);
                erro = true;
                return;
            }
        }  
    }
    
    void CriarArquivo() throws IOException{
        
        String NomeArquivo;     // Nome do arquivo onde será gravado os dados da partida
        
        do{
            
            // input do nome do arquivo a ser criado
            NomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo a ser criado.");
            NomeArquivo = NomeArquivo + ".txt";
            
            // Verifica se o nome de arquivo que o usuário inseriu já não está sendo usado na pasta da data em que a partida foi realizada. 
            if(VerificarNomeArquivo(NomeArquivo) == true){
                break;
            }
            
            JOptionPane.showMessageDialog(null, "Este nome de arquivo '"+NomeArquivo+"' já está sendo utilizado. Por favor, insira um novo nome.", "NOME DE ARQUIVO DUPLICADO", JOptionPane.INFORMATION_MESSAGE);
        } 
        while(true);
        
        // Cria o caminho para salvar o arquivo no local correto
        CaminhoArquivo = PastaData.getAbsolutePath() + File.separator + NomeArquivo;
        
        // Cria um objeto File que representa o arquivo que será criado
        File arquivo = new File(CaminhoArquivo);
        
        // Cria o arquivo para gravar os dados da partida
        if (arquivo.createNewFile()) {
            System.out.println("Arquivo criado com sucesso: " + arquivo.getAbsolutePath());
        } 
        else {
            JOptionPane.showMessageDialog(null, "Erro ao tentar criar o arquivo "+NomeArquivo+" para salvar este jogo. Não será possível salvá-lo.", "ERRO DE SALVAMENTO", JOptionPane.INFORMATION_MESSAGE);
            erro = true;
            return;
        }
        
        // nome arquivo criado é o nome do arquivo inserido pelo usuário + formatação de arquivo de texto(.txt)
        NomeArquivoCriado = NomeArquivo;
            
    }
    
    boolean VerificarNomeArquivo(String NomeArquivo) throws IOException{
        
        // Obtém a lista de nomes de arquivo na pasta da data da partida
        String[] NomesArquivosExistentes = PastaData.list();

        // Verifica se o nome de arquivo fornecido pelo usuário já existe
        if ((NomesArquivosExistentes != null) && (NomesArquivosExistentes.length > 0)) {
            for (String NomeExistente : NomesArquivosExistentes) {
                if (NomeExistente.equals(NomeArquivo)) {
                    return false; // Retorna para evitar a criação do arquivo com nome duplicado
                }
            }
        }
        
        // Caso não exista, o nome do arquivo é considerado válido
        return true;
 
    }
    
    void PreencherArquivo(Time[] time, Partida[] partida, int[][] set) throws IOException{
        
        // redefine o caminho do arquivo substituindo o nome do arquivo pelo nome do arquivo criado
        CaminhoArquivo = PastaData.getAbsolutePath() + File.separator + NomeArquivoCriado;

        BufferedWriter escrever = new BufferedWriter(new FileWriter(CaminhoArquivo));
    
        for(int contador = 0; contador < 2; contador++){
            escrever.write(time[contador].Nome);
            escrever.newLine();
            escrever.write(Integer.toString(time[contador].Set));
            escrever.newLine();
        }

        escrever.write(partida[0].Vencedor);
        escrever.newLine();
        escrever.write(partida[0].Perdedor);
        escrever.newLine();
        
        for (int NomeTime = 0; NomeTime < 2; NomeTime++){
            for( int NumeroSet = 0; NumeroSet < 5; NumeroSet++){
                escrever.write(Integer.toString(set[NomeTime][NumeroSet]));
                escrever.newLine();
            }
        }
        
        // fechando o arquivo já preenchido
        escrever.close();
        
    }
    
}
