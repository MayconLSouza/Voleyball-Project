/*
    Nome do programa: Sistema_Volei
    Classe: Jogo
    Objetivo: Realizar uma partida de vôlei de acordo com as configurações pré-estabelecidas.
    Nomes dos Programadores: Maycon L.M. Souza e Otávio Augusto 
    Data de atualização:  08/07/2023
*/
import javax.swing.*;                   // Biblioteca para janela de interação

public class RealizarJogo {
    
    void IniciarPartida (Time[] time, Partida[] partida, int[][] set){
        int diferenca = 0, ponto, OpcaoPonto = 0, NumeroSet;
        while((time[0].Set < 3) && (time[1].Set < 3)){
            ponto = 1;
            NumeroSet = time[0].Set+time[1].Set;
            if(NumeroSet < 4){
                while( ( (time[0].Pontos < partida[0].PontoLimite) && (time[1].Pontos < partida[0].PontoLimite) ) || (diferenca < 2) ){
                    OpcaoPonto = Integer.parseInt(JOptionPane.showInputDialog(time[0].Nome+"| "+time[0].Pontos+" | x | "+time[1].Pontos+" | "+time[1].Nome+"\n"
                                +"-------------------------------------------------------------------------\n"
                                +time[0].Set+" | Sets | "+time[1].Set+"\n"
                                +"-------------------------------------------------------------------------\n"
                                +"Quem fez o "+ponto+"° ponto do set "+(NumeroSet+1)+"?\n"
                                +"-------------------------------------------------------------------------\n"
                                +" 1 - "+time[0].Nome+"\n"
                                +" 2 - "+time[1].Nome+"\n"
                                +"-------------------------------------------------------------------------"));
                    switch(OpcaoPonto){
                        case 1 -> {
                            time[0].Pontos += 1;
                            ponto += 1;
                            diferenca = CalcularDiferenca(time, diferenca);
                        }
                        case 2 -> {
                            time[1].Pontos += 1;
                            ponto += 1;
                            diferenca = CalcularDiferenca(time, diferenca);
                        }
                        default -> JOptionPane.showMessageDialog(null, "Por favor digite novamente uma das opções a seguir.","OPÇÃO INVÁLIDA!!!",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            else if(NumeroSet == 4){
                while( ( (time[0].Pontos < partida[0].PontoLimite5Set) && (time[1].Pontos < partida[0].PontoLimite5Set) ) || (diferenca < 2)){
                    OpcaoPonto = Integer.parseInt(JOptionPane.showInputDialog(time[0].Nome+"| "+time[0].Pontos+" | x | "+time[1].Pontos+" | "+time[1].Nome+"\n"
                                +"-------------------------------------------------------------------------\n"
                                +time[0].Set+" | Sets | "+time[1].Set+"\n"
                                +"-------------------------------------------------------------------------\n"
                                +"Quem fez o "+ponto+"° ponto do set "+(NumeroSet+1)+"?\n"
                                +"-------------------------------------------------------------------------\n"
                                +" 1 - "+time[0].Nome+"\n"
                                +" 2 - "+time[1].Nome+"\n"
                                +"-------------------------------------------------------------------------"));
                    switch(OpcaoPonto){
                        case 1 -> {
                            time[0].Pontos += 1;
                            ponto += 1;
                            diferenca = CalcularDiferenca(time, diferenca);
                        }
                        case 2 -> {
                            time[1].Pontos += 1;
                            ponto += 1;
                            diferenca = CalcularDiferenca(time, diferenca);
                        }
                        default -> JOptionPane.showMessageDialog(null, "Por favor digite novamente uma das opções a seguir.","OPÇÃO INVÁLIDA!!!",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            JOptionPane.showMessageDialog(null,"Fim do "+(NumeroSet+1)+"° set. O vencedor foi "+VencedorSet(time, NumeroSet)+".\nPelo placar de "+time[0].Pontos+" x "+time[1].Pontos+".");
            Placar(time,set,NumeroSet);
            ZerarPontos(time);
        }
        partida[0].Vencedor = VencedorPartida(time);
        partida[0].Perdedor = PerdedorPartida(time);
    }
    
    static int CalcularDiferenca(Time[] time, int diferenca){
        if(time[0].Pontos >= time[1].Pontos){
            diferenca = time[0].Pontos-time[1].Pontos;
            return diferenca;
        }
        else{
            diferenca = time[1].Pontos-time[0].Pontos;
            return diferenca;
        }
    }
    
    static String VencedorSet(Time[] time, int NumeroSet){
        if(time[0].Pontos > time[1].Pontos){
            time[0].Set += 1;
            return time[0].Nome;
        }
        else if(time[1].Pontos > time[0].Pontos){
            time[1].Set += 1;
            return time[1].Nome;
        }
        else{
            JOptionPane.showMessageDialog(null,"ERRO DE CONTAGEM DE PONTOS NO SET!!!");
            return "";
        }
    }
    
    void Placar(Time[] time, int[][] set, int NumeroSet){
        set[0][(NumeroSet)] = time[0].Pontos;
        set[1][(NumeroSet)] = time[1].Pontos;
    }
    
    void ZerarPontos(Time[] time){
        time[0].Pontos = 0;
        time[1].Pontos = 0;
    }
    
    static String VencedorPartida(Time[] time){
        if(time[0].Set > time[1].Set){
            return time[0].Nome;
        }
        else if(time[1].Set > time[0].Set){
            return time[1].Nome;
        }
        else{
            JOptionPane.showMessageDialog(null,"ERRO EM DETERMINAR QUEM VENCEU A PARTIDA!!!");
            return ""; 
        }
    }
    
    static String PerdedorPartida(Time[] time){
        if(time[0].Set > time[1].Set){
            return time[1].Nome;
        }
        else if(time[1].Set > time[0].Set){
            return time[0].Nome;
        }
        else{
            JOptionPane.showMessageDialog(null,"ERRO EM DETERMINAR QUEM PERDEU A PARTIDA!!!");
            return ""; 
        }
    }
    
}
