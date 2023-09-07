/*
    Nome do programa: Sistema_Volei
    Classe: Estatística
    Objetivo: Exibir as estatísticas de uma partida de vôlei.
    Nomes dos Programadores: Maycon L.M. Souza e Otávio Augusto 
    Data de atualização:  09/07/2023
*/
import javax.swing.*;

public class Estatistica {
    
    //***********
    // menu de estatísticas da partida, acessado através da opção 3 do menu principal
    //***********
    void Estatisticas(Time[] time, Partida[] partida,int[][] set){
        String MenuEstatistica = "MENU ESTATÍSTICA\n"
            + "----------------------------------------------------------------\n"
            + "Escolha uma das opcões a seguir\n"
            + "----------------------------------------------------------------\n"             
            + "1 - Estatísticas do 1° Set\n" 
            + "2 - Estatísticas do 2° Set\n" 
            + "3 - Estatísticas do 3° Set\n" 
            + "4 - Estatísticas do 4° Set\n"
            + "5 - Estatísticas do 5° Set\n"
            + "6 - Vencedor da partida\n" 
            + "7 - Perdedor da partida\n"
            + "8 - Mostrar todas as estatísticas da partida\n"    
            + "9 - Fim do menu estatísticas";
        int OpcaoEstatistica = 0;
        while(OpcaoEstatistica != 9){
            OpcaoEstatistica = Integer.parseInt(JOptionPane.showInputDialog(MenuEstatistica));
            switch(OpcaoEstatistica){
                case 1 -> {
                    PrimeiroSet(time, set);
                }
                case 2 -> {
                    SegundoSet(time, set);
                }
                case 3 -> {
                    TerceiroSet(time, set);
                }
                case 4 -> {
                    QuartoSet(time, set);
                }
                case 5 -> {
                    QuintoSet(time, set);
                }
                case 6 -> {
                    Vencedor(time, partida);
                }
                case 7 -> {
                    Perdedor(time, partida);
                }
                case 8 -> {
                    PrimeiroSet(time, set);
                    SegundoSet(time, set);
                    TerceiroSet(time, set);
                    QuartoSet(time, set);
                    QuintoSet(time, set);
                    Vencedor(time, partida);
                    Perdedor(time, partida);                    
                }
                case 9 -> {
                    JOptionPane.showMessageDialog(null,"Fim do menu estatísticas. Retornando ao menu principal.","FIM DA ANÁLISE TÉCNICA",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                default -> JOptionPane.showMessageDialog(null, "Por favor digite novamente uma das opções a seguir.","OPÇÃO INVÁLIDA!!!",JOptionPane.INFORMATION_MESSAGE);
            }
        }        
    }
    
    void PrimeiroSet(Time[] time, int [][] set){
        String Message = time[0].Nome+" | "+set[0][0]+" x "+set[1][0]+" | "+time[1].Nome; 
        JOptionPane.showMessageDialog(null,Message,"PLACAR FINAL DO 1° SET",JOptionPane.INFORMATION_MESSAGE);
        if(set[0][0] > set[1][0]){
            JOptionPane.showMessageDialog(null,time[0].Nome+" foi o vencedor do 1° Set.","VENCEDOR",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(set[1][0] > set[0][0]){
            JOptionPane.showMessageDialog(null,time[1].Nome+" foi o vencedor do 1° Set.","VENCEDOR",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"Não foi possível determinar o vencedor do 1° Set.","ERRO!!!",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    void SegundoSet(Time[] time, int [][] set){
        String Message = time[0].Nome+" | "+set[0][1]+" x "+set[1][1]+" | "+time[1].Nome; 
        JOptionPane.showMessageDialog(null,Message,"PLACAR FINAL DO 2° SET",JOptionPane.INFORMATION_MESSAGE);
        if(set[0][1] > set[1][1]){
            JOptionPane.showMessageDialog(null,time[0].Nome+" foi o vencedor do 2° Set.","VENCEDOR",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(set[1][1] > set[0][1]){
            JOptionPane.showMessageDialog(null,time[1].Nome+" foi o vencedor do 2° Set.","VENCEDOR",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"Não foi possível determinar o vencedor do 2° Set.","ERRO!!!",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    void TerceiroSet(Time[] time, int [][] set){
        String Message = time[0].Nome+" | "+set[0][2]+" x "+set[1][2]+" | "+time[1].Nome; 
        JOptionPane.showMessageDialog(null,Message,"PLACAR FINAL DO 3° SET",JOptionPane.INFORMATION_MESSAGE);
        if(set[0][2] > set[1][2]){
            JOptionPane.showMessageDialog(null,time[0].Nome+" foi o vencedor do 3° Set.","VENCEDOR",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(set[1][2] > set[0][2]){
            JOptionPane.showMessageDialog(null,time[1].Nome+" foi o vencedor do 3° Set.","VENCEDOR",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"Não foi possível determinar o vencedor do 3° Set.","ERRO!!!",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    void QuartoSet(Time[] time, int [][] set){
        String Message = time[0].Nome+" | "+set[0][3]+" x "+set[1][3]+" | "+time[1].Nome;
        if((set[0][3] == 0) && (set[1][3] == 0)){
            JOptionPane.showMessageDialog(null,"Não houve 4°Set. A partida terminou anteriormente.","FIM DA PARTIDA",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,Message,"PLACAR FINAL DO 4° SET",JOptionPane.INFORMATION_MESSAGE);
            if(set[0][3] > set[1][3]){
                JOptionPane.showMessageDialog(null,time[0].Nome+" foi o vencedor do 4° Set.","VENCEDOR",JOptionPane.INFORMATION_MESSAGE);
            }
            else if(set[1][3] > set[0][3]){
                JOptionPane.showMessageDialog(null,time[1].Nome+" foi o vencedor do 4° Set.","VENCEDOR",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"Não foi possível determinar o vencedor do 4° Set.","ERRO!!!",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    void QuintoSet(Time[] time, int [][] set){
        String Message = time[0].Nome+" | "+set[0][4]+" x "+set[1][4]+" | "+time[1].Nome;
        if((set[0][4] == 0) && (set[1][4] == 0)){
            JOptionPane.showMessageDialog(null,"Não houve 5°Set. A partida terminou anteriormente.","FIM DA PARTIDA",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,Message,"PLACAR FINAL DO 5° SET",JOptionPane.INFORMATION_MESSAGE);
            if(set[0][4] > set[1][4]){
                JOptionPane.showMessageDialog(null,time[0].Nome+" foi o vencedor do 5° Set.","VENCEDOR",JOptionPane.INFORMATION_MESSAGE);
            }
            else if(set[1][4] > set[0][4]){
                JOptionPane.showMessageDialog(null,time[1].Nome+" foi o vencedor do 5° Set.","VENCEDOR",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"Não foi possível determinar o vencedor do 5° Set.","ERRO!!!",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    void Vencedor(Time[] time, Partida[] partida){
        String Message = "O vencedor da partida foi "+partida[0].Vencedor+" pelo seguinte placar:\n" 
                +time[0].Nome+" | "+time[0].Set+" x "+time[1].Set+" | "+time[1].Nome;
        JOptionPane.showMessageDialog(null,Message,"VENCEDOR DA PARTIDA",JOptionPane.INFORMATION_MESSAGE);
    }
    
    void Perdedor(Time[] time, Partida[] partida){
        String Message = "O perdedor da partida foi "+partida[0].Perdedor+" pelo seguinte placar:\n" 
                +time[0].Nome+" | "+time[0].Set+" x "+time[1].Set+" | "+time[1].Nome;
        JOptionPane.showMessageDialog(null,Message,"PERDEDOR DA PARTIDA",JOptionPane.INFORMATION_MESSAGE);
    }
    
}
