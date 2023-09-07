/*
    Nome do programa: Sistema_Volei
    Classe: Abstrata
    Objetivo: Construtor do objeto partida.
    Nomes dos Programadores: Maycon L.M. Souza e Otávio Augusto 
    Data de atualização : 08/07/2023

    Anotações:
        Armazena os atributos necessários para a inicialização da partida: Limite de pontos, Limite de sets e regra de desempate
        Armazena os resultados da partida anterior como: Vencedor e Perdedor
*/
class Partida{
    //=================================================================================
    // Declaração de Váriaveis
    int PontoLimite, LimiteSets, PontoLimite5Set;    // Limite de pontos por Set | Limite de Sets por partida
    String Vencedor, Perdedor;      // Armazena o time vencedor | Armazena o time perdedor
    
    //=================================================================================
    // Atribuição dos atributos da Partida
    Partida(int LimitePonto, int SetNumero, int LimitePonto5Set, String Ganhador, String Derrotado){
        PontoLimite = LimitePonto;  // Limite dos pontos dentro de um set
        LimiteSets = SetNumero; // Numero máx de sets em uma partida
        PontoLimite5Set = LimitePonto5Set; // Limite de pontos no último set
        Vencedor = Ganhador;    // Nome do time que venceu o jogo anterior
        Perdedor = Derrotado;   // Nome do time que perdeu o jogo
    }//================================================================================
}
