O programa simula os roteadores de uma rede.O programa deve obter as informações de configuração de arquivos. Cada roteador deve ser capaz de conversar com outros roteadores (mesmo programa rodando como outros processos) através de socket UDP.
Cada roteador conhece os seus vizinhos e a distância (custo dos enlaces) até os mesmos. Os roteadores trocam informações de roteamento utilizando o algoritmo Bellman-Ford distribuído.

O programa lê pelo menos um parâmetro da linha de comando, sendo este o ID do roteador.  Informação sobre os enlaces existentes entre os roteadores são obtidas do arquivo de configuração enlaces.config. Informações sobre em quais portas UDP cada roteador está se comunicando com os demais roteadores  são obtidas do arquivo de configuração roteador.config.

Os roteadores devem trocar informações de roteamento periodicamente para manter as rotas atualizadas. Assumindo uma rede conectada, as tabelas de roteamente convergem após um determinado tempo.

Os roteadores podem ser "ligados" ou "desligados" (criando ou "matando" os processos correspondentes) a qualquer momento. O roteamento deve se adaptar a estas situações. Você também deve tratar o problema de contagem ao infinito (count to infinity). Observe que você não vai resolver o problema da contagem ao infinito (como exemplo de um protocolo vetor distância sem o problema da contagem ao infinito verifique o protocolo DUAL), apenas defina um valor finito (i.e., valor > diâmetro da rede) para parar a contagem, caso ela ocorra!

Após cada  atualização da tabela de rotas o roteador deve retornar a tabela no console com o timestamp da mudança. Ele também deve apresentar uma mensagem quando recebe ou envia pacotes.
Cada roteador se comunica somente com os seus vizinhos imediatos (adjacentes), utilizando os seus respectivos sockets (informação obtida do arquivo de configuração roteador.config) para enviar e receber mensagens.