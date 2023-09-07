/*
    Nome do programa: Sistema_Volei
    Classe: Abstrata
    Objetivo: Construtor do objeto Time.
    Nomes dos Programadores: Maycon L.M. Souza e Otávio Augusto 
    Data de atualização : 08/07/2023
    
    Anotações:
        Armazena informações do time enquanto o jogo está em andamento!
        Após o jogo terminar  os dados vão para o objeto Estatisticas e esse objeto será limpo
*/
class Time {
    //=================================================================================
    //Declaração de Váriáveis
    int Pontos, Set;
    String Nome;
    //=================================================================================
    // Atribuição dos atributos do Time
    Time(int PontosTime, int NumeroSet, String NomeTime){
        Pontos = PontosTime;    // Pontos feitos pelo time
        Set = NumeroSet;        // Numero de Sets vencidos pelo time
        Nome = NomeTime;        // Nome do time
    }//================================================================================
}
