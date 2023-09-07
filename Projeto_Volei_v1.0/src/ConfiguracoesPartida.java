/*
    Nome do programa: Sistema_Volei
    Classe: Configurações
    Objetivo: Definir as regras da partida a ser jogada.
    Nomes dos Programadores: Maycon L.M. Souza e Otávio Augusto 
    Data de atualização:  08/07/2023
 */
import javax.swing.*;

public class ConfiguracoesPartida {

    void ConfigurarPartida(Time[] time, Partida[] partida){
        NomearTime(time);                    
        RegrasOficiais(partida);
    }
    
    void NomearTime(Time[] time){
        time[0].Nome = JOptionPane.showInputDialog("Digite o nome do time da casa.");
        time[1].Nome = JOptionPane.showInputDialog("Digite o nome do time visitante.");
    }

    void RegrasOficiais(Partida[] partida){
        partida[0].PontoLimite = 5;
        partida[0].LimiteSets = 5;
        partida[0].PontoLimite5Set = 3;
    }
}
