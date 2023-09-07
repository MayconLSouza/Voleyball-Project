/*
    Nome do programa: Sistema_Volei
    Classe: Regras
    Objetivo: Manual de regras oficiais do jogo de vôlei.
    Nomes dos Programadores: Maycon L.M. Souza e Otávio Augusto 
    Data de atualização:  09/07/2023
*/
//=========================================================================================
// Biblioteca
import javax.swing.*;       // Biblioteca para janela de interação
//=========================================================================================

public class ConsultarRegras {
    
    //***********
    // menu de regras de vôlei, acessado através da opção 4 do menu principal
    //***********
    void RegrasJogoVolei(){
        String MenuRegras = """
                            MENU REGRAS
                            ----------------------------------------------------------------
                            Escolha uma das opcões a seguir
                            ----------------------------------------------------------------
                            1 - O que é o vôlei? 
                            2 - Regras do jogo de vôlei
                            3 - Regras de uma partida oficial de vôlei 
                            4 - Posição dos jogadores
                            9 - Fim do menu regras
                            """;
        String VoleiTexto = """
                            O voleibol ou vôlei é um esporte praticado entre duas equipes numa quadra retangular (aberta ou fechada).
                            Ela é dividida por uma rede colocada verticalmente sobre a linha central. O voleibol é jogado com uma bola e inclui diversos passes com as mãos.
                            O objetivo principal é lançar a bola por cima da rede e fazê-la tocar no chão do adversário.
                            """;
        String VoleiHistoria = """
                               O vôlei foi criado em 1895 por William George Morgan, diretor de Educação Física da Associação Cristã de Moços (ACM) dos Estados Unidos.
                               O esporte chegou ao Brasil em 1916. Nessa época, era praticado em clubes elitizados, e hoje se tornou a segunda modalidade esportiva mais praticada no país, atrás apenas do futebol.
                               A primeira edição do Campeonato Mundial de Vôlei ocorreu em 1949 (masculina) e em 1952 (feminina). A estreia nas Olimpíadas aconteceu no ano de 1964, nos jogos de Tóquio.
                               """;
        String VoleiEsporte = """
                              O esporte possui diversos benefícios, como a melhora das habilidades físicas (força e velocidade) e a integração social.
                              Entre seus fundamentos, estão: ataque, defesa, toque/levantamento, bloqueio e manchete.
                              """;
        String PartidaOficial = """
                                1. Cada equipe possui um técnico.
                                2. Uma partida é constituída de 5 sets.
                                3. Não existe tempo pré-determinado para cada set.
                                4. Cada set tem um máximo de 25 pontos com uma diferença mínima de 2 pontos.
                                5. Em caso de empate no set no final (24 x 24), a partida continua até que a diferença de dois pontos seja atingida (26 x 24, 27 x 25, etc.).
                                6. Ganha a equipe que vencer três sets.
                                7. Se houver empate nos sets (2x2) o 5º set será decisivo e terá um máximo de 15 pontos com uma diferença mínima de 2 pontos.
                                """;
        int OpcaoRegras = 0;
        while(OpcaoRegras != 9){
            OpcaoRegras = Integer.parseInt(JOptionPane.showInputDialog(MenuRegras));
            switch(OpcaoRegras){
                case 1 -> {
                    JOptionPane.showMessageDialog(null,VoleiTexto,"O QUE É O VÔLEI?",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,VoleiHistoria,"HISTÓRIA DO VÔLEI",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,VoleiEsporte,"ESPORTE VÔLEI",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,"Parabéns, você aprendeu sobre a o que é o vôlei, sua história e mais sobre esse esporte. Retornando agora ao menu regras.","O QUE É VÔLEI?",JOptionPane.INFORMATION_MESSAGE);
                }
                case 2 -> {
                    RegrasJogo();
                    JOptionPane.showMessageDialog(null,"Parabéns, você aprendeu as regras e como se joga vôlei. Retornando ao menu regras.","REGRAS DO JOGO DE VÔLEI",JOptionPane.INFORMATION_MESSAGE);
                }
                case 3 -> {
                    JOptionPane.showMessageDialog(null,PartidaOficial,"REGRAS DE UMA PARTIDA OFICIAL",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,"Parabéns, você aprendeu as regras de uma partida oficial de vôlei. Retornando ao menu regras.","REGRAS DE UMA PARTIDA OFICIAL",JOptionPane.INFORMATION_MESSAGE);
                }
                case 4 -> {
                    Posicao();
                    JOptionPane.showMessageDialog(null,"Parabéns, você aprendeu sobre as posições dos jogadores em uma partida de vôlei. Retornando ao menu regras.","POSIÇÕES DOS JOGADORES",JOptionPane.INFORMATION_MESSAGE);
                }
                case 9 -> {
                    JOptionPane.showMessageDialog(null,"Fim do menu regras. Retornando ao menu principal.","FIM DO MANUAL DE REGRAS",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                default -> JOptionPane.showMessageDialog(null, "Por favor digite novamente uma das opções a seguir.","OPÇÃO INVÁLIDA!!!",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    //***********
    // menu de regras do jogo de vôlei, acessado através da opção 2 do menu regras
    //***********
    void RegrasJogo(){
        String MenuRegrasJogo = """
                                MENU REGRAS DO JOGO DE VÔLEI
                                ----------------------------------------------------------------
                                Escolha uma das opcões a seguir
                                ----------------------------------------------------------------
                                1 - Equipes
                                2 - Quadra 
                                3 - Ponto 
                                4 - Saque
                                5 - Rodízio
                                6 - Toques
                                7 - Levantamento
                                8 - Ataque
                                9 - Bloqueio
                                10 - Faltas
                                11 - Jogadores
                                12 - Mostrar todas as regras
                                13 - Fim do menu regras do jogo de vôlei
                                """;
        String Equipe = """
                        O vôlei é jogado entre duas equipes de seis jogadores cada.
                        Cada equipe tenta marcar pontos lançando a bola por cima da rede e fazendo-a tocar o chão no campo do adversário,
                        enquanto a outra equipe tenta impedir isso e devolver a bola para o lado oposto.
                        """;
        String Quadra = """
                        A quadra de vôlei é retangular e dividida em duas metades por uma rede.
                        As dimensões da quadra variam, mas geralmente tem cerca de 18 metros de comprimento e 9 metros de largura.
                        """;
        String Ponto = "Um ponto é marcado sempre que a bola toca o chão no campo do adversário ou quando a equipe adversária comete uma falta.";
        String Saque = """
                        O jogo começa com um saque, onde um jogador deve lançar a bola por cima da rede para o campo adversário.
                        O saque é feito a partir da zona de saque e deve passar por cima da rede.
                        O jogador que realiza o saque não pode pisar na linha de quadra senão será uma falta e a equipe adversária ganhará o ponto.
                       """;
        String Rodizio = """
                         Após cada ponto marcado, as equipes devem girar no sentido horário.
                         Isso significa que cada jogador deve ocupar uma nova posição na quadra, mantendo-se na ordem.
                         Exceto no primeiro ponto de cada time.
                         """;
        String Toques = """
                        Cada equipe tem direito a três toques para devolver a bola para o campo adversário.
                        Os jogadores podem tocar a bola com qualquer parte do corpo, mas não podem dar dois toques consecutivos, exceto no bloqueio.
                        """;
        String Levantamento = """
                              Um tipo específico de toque é chamado de levantamento. É usado para direcionar a bola para um ataque. 
                              O levantamento ocorre quando um jogador toca a bola acima da cabeça, usando apenas as pontas dos dedos.
                              """;
        String Ataque = """
                        Após o levantamento, um jogador pode atacar a bola, tentando fazê-la tocar o chão no campo adversário.
                        O ataque geralmente envolve um salto e um golpe poderoso na bola.
                        """;
        String Bloqueio = """
                          Quando a equipe adversária ataca, os jogadores podem pular e tentar bloquear o ataque, 
                          impedindo que a bola toque o chão ou até devolvendo-a para a quadra da equipe adversária. 
                          O bloqueio não conta como um dos três toques da equipe.
                          """;
        String Faltas = """
                        Algumas ações são consideradas faltas, resultando em um ponto para a equipe adversária. 
                        Isso inclui tocar a rede durante o jogo, pisar na linha de quadra ao sacar, o mesmo jogador tocar a bola duas vezes consecutivas (exceto no bloqueio), 
                        erro de rotação da equipe (não realizando-a ou realizando de maneira incorreta) e outras violações das regras.
                        """;
        String Jogadores = "O vôlei de quadra é formado por duas equipes com 6 jogadores em cada. No total, são 12 jogadores. Existem ainda 6 jogadores reserva.";
        int OpcaoRegrasJogo = 0;
        while(OpcaoRegrasJogo != 13){
            OpcaoRegrasJogo = Integer.parseInt(JOptionPane.showInputDialog(MenuRegrasJogo));
            switch(OpcaoRegrasJogo){
                case 1 -> {
                    JOptionPane.showMessageDialog(null,Equipe,"EQUIPE",JOptionPane.INFORMATION_MESSAGE);
                }
                case 2 -> {
                    JOptionPane.showMessageDialog(null,Quadra,"QUADRA",JOptionPane.INFORMATION_MESSAGE);
                }
                case 3 -> {
                    JOptionPane.showMessageDialog(null,Ponto,"PONTO",JOptionPane.INFORMATION_MESSAGE);
                }
                case 4 -> {
                    JOptionPane.showMessageDialog(null,Saque,"SAQUE",JOptionPane.INFORMATION_MESSAGE);
                }
                case 5 -> {
                    JOptionPane.showMessageDialog(null,Rodizio,"RODÍZIO",JOptionPane.INFORMATION_MESSAGE);
                }
                case 6 -> {
                    JOptionPane.showMessageDialog(null,Toques,"TOQUES",JOptionPane.INFORMATION_MESSAGE);
                }
                case 7 -> {
                    JOptionPane.showMessageDialog(null,Levantamento,"LEVANTAMENTO",JOptionPane.INFORMATION_MESSAGE);
                }
                case 8 -> {
                    JOptionPane.showMessageDialog(null,Ataque,"ATAQUE",JOptionPane.INFORMATION_MESSAGE);
                }
                case 9 -> {
                    JOptionPane.showMessageDialog(null,Bloqueio,"BLOQUEIO",JOptionPane.INFORMATION_MESSAGE);
                }
                case 10 -> {
                    JOptionPane.showMessageDialog(null,Faltas,"FALTAS",JOptionPane.INFORMATION_MESSAGE);
                }
                case 11 -> {
                    JOptionPane.showMessageDialog(null,Jogadores,"JOGADORES",JOptionPane.INFORMATION_MESSAGE);
                }
                case 12 -> {
                    JOptionPane.showMessageDialog(null,Equipe,"EQUIPE",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,Quadra,"QUADRA",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,Ponto,"PONTO",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,Saque,"SAQUE",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,Rodizio,"RODÍZIO",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,Toques,"TOQUES",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,Levantamento,"LEVANTAMENTO",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,Ataque,"ATAQUE",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,Bloqueio,"BLOQUEIO",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,Faltas,"FALTAS",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,Jogadores,"JOGADORES",JOptionPane.INFORMATION_MESSAGE);
                }
                case 13 -> {
                    return;
                }
                default -> JOptionPane.showMessageDialog(null, "Por favor digite novamente uma das opções a seguir.","OPÇÃO INVÁLIDA!!!",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    //***********
    // menu de posição dos jogadores, acessado através da opção 4 do menu regras
    //***********
    void Posicao(){
        String MenuPosicao = """
                             MENU POSIÇÃO DOS JOGADORES
                             ----------------------------------------------------------------
                             Escolha uma das opcões a seguir
                             ----------------------------------------------------------------
                             1 - Levantador 
                             2 - Central 
                             3 - Ponteiro
                             4 - Oposto
                             5 - Líbero
                             6 - Mostrar todas as posições
                             9 - Fim do menu posição dos jogadores
                             """;
        String Levantador = """
                            O Levantador do Voleibol é o “cérebro” de uma equipe, pois ele é o responsável por armar as jogadas de ataque.
                            Ele é quem vai decidir se a equipe vai realizar uma jogada mais rápida ou mais lenta no ataque. A principal técnica usada pelo levantador é o “Toque”, 
                            mas ele também pode usar a “Manchete” ou outro recurso técnico criativo para realizar um levantamento e preparar um ataque da sua equipe. 
                            Após o saque da equipe adversária o Levantador deve se posicionar na zona de ataque para receber a segunda bola e efetuar o levantamento.
                            """;
        String Central = """
                         O Central é, quase sempre, o jogador mais alto de uma equipe de Voleibol. O Central se posiciona no centro da “Rede” ou zona de ataque (posição 3), 
                         é protagonista nos “Bloqueios” e responsável por atacar a bola de 1º tempo (aquele ataque curto e rápido próximo a rede). 
                         Na Zona de Defesa (posições 5, 6 e 1) o Central quase sempre é substituído pelo Líbero, pois, raramente, um Central tem como características técnicas ser um bom defensor ou passador.
                         """;
        String Ponteiro = """
                          O Ponteiro é um especialista em ataque, principalmente na posição 4 (entrada de rede) da zona de ataque, e compõe a linha de “Bloqueio” junto com o Central. 
                          Na Zona de Defesa o Ponteiro se destaca como um bom passador, podendo ocupar a posição 6 (no centro da zona de defesa) e compor a linha de recepção do saque junto com o Líbero ou outro ponteiro.
                          Ainda quando posicionado na zona de defesa o Ponteiro pode atuar atacando as bolas de “segundo tempo” saltando atrás da linha de 3 metros.
                          """;
        String Oposto = """
                        O Oposto é o jogador que recebe o maior volume de bolas do Levantador para atacar. O termo “Oposto” vem justamente do fato dele se posicionar sempre na posição oposta ao levantador, 
                        facilitando assim que ele receba o maior volume de bola para atacar. Na zona de ataque o Oposto normalmente ocupa a posição 2 (saída de rede) e ajuda a formar o bloqueio junto com o Central. 
                        Na zona de defesa o Oposto normalmente não participa da recepção do saque, ficando escondido atrás do Ponteiro e do Líbero e se movimentando para fazer o ataque atrás da linha dos 3 metros próximo a posição 2.
                        """;
        String Libero = """
                        O Líbero é um jogador especialista em passe e defesa que atua apenas na Zona de Defesa ou fundo de quadra (posições 1, 6 e 5). 
                        O Líbero normalmente substitui o Central quando este está passando pela zona de defesa. 
                        Existe diversas limitações ao Líbero, como por exemplo, não poder atacar, não pode bloquear, e não fazer um levantamento de “toque” estando na região da “rede”(zona de ataque), 
                        caso faça o levantamento de toque na região de ataque, o atacante não poderá atacá-la acima da borda superior da rede.
                        """;
        int OpcaoPosicao = 0;
        while(OpcaoPosicao != 9){
            OpcaoPosicao = Integer.parseInt(JOptionPane.showInputDialog(MenuPosicao));
            switch(OpcaoPosicao){
                case 1 -> {
                    JOptionPane.showMessageDialog(null,Levantador,"LEVANTADOR",JOptionPane.INFORMATION_MESSAGE);
                }
                case 2 -> {
                    JOptionPane.showMessageDialog(null,Central,"CENTRAL",JOptionPane.INFORMATION_MESSAGE);
                }
                case 3 -> {
                    JOptionPane.showMessageDialog(null,Ponteiro,"PONTEIRO",JOptionPane.INFORMATION_MESSAGE);
                }
                case 4 -> {
                    JOptionPane.showMessageDialog(null,Oposto,"OPOSTO",JOptionPane.INFORMATION_MESSAGE);
                }
                case 5 -> {
                    JOptionPane.showMessageDialog(null,Libero,"LÍBERO",JOptionPane.INFORMATION_MESSAGE);
                }
                case 6 -> {
                    JOptionPane.showMessageDialog(null,Levantador,"LEVANTADOR",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,Central,"CENTRAL",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,Ponteiro,"PONTEIRO",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,Oposto,"OPOSTO",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,Libero,"LÍBERO",JOptionPane.INFORMATION_MESSAGE);
                }
                case 9 -> {
                    return;
                }
                default -> JOptionPane.showMessageDialog(null, "Por favor digite novamente uma das opções a seguir.","OPÇÃO INVÁLIDA!!!",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
