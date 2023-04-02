# Projeto Locadora Distribuida  

## Objetivo
O objetivo deste projeto é fazer um gerenciador simples de uma locadora de filmes usando o conceito de sistemas distribuidos. 
Utilizando de **sockets**, o software programado em **java** possui um servidor onde todo o processamento é direcionado a ele, 
e um cliente, onde fica toda a interface do programa.  

## Funcionalidades  
O software possui diversas funcionalidades que auxiliam no gerenciamento básico de uma locadora de filmes.  

![Menu Locadora](https://github.com/pauloszuparits/Imagens/blob/97fcd78b973964c66e55e1d89fa7fafbdceeaba7/imgLocadoraDistribuida/MenuLocadoraDistribuida.png)  

#### CRUD filmes
No sistema é possivel **Cadastrar, buscar, listar e remover** filmes.  

![Exemplo cadastro filmes locadora](https://github.com/pauloszuparits/Imagens/blob/97fcd78b973964c66e55e1d89fa7fafbdceeaba7/imgLocadoraDistribuida/CadastroDeFilmesLocadoraDistribuida.png)  

![Exemplo listagem filmes locadora](https://github.com/pauloszuparits/Imagens/blob/97fcd78b973964c66e55e1d89fa7fafbdceeaba7/imgLocadoraDistribuida/ListagemFilmesLocadoraDistribuida.png)  

#### CRUD Clientes
No sistema também é possivel **Cadastrar, buscar, listar e remover** clientes.  

![Exemplo cadastro cliente](https://github.com/pauloszuparits/Imagens/blob/97fcd78b973964c66e55e1d89fa7fafbdceeaba7/imgLocadoraDistribuida/CadastroClienteLocadoraDistribuida.png)  

![Exemplo listagem cliente](https://github.com/pauloszuparits/Imagens/blob/97fcd78b973964c66e55e1d89fa7fafbdceeaba7/imgLocadoraDistribuida/ListagemClientesLocadoraDistribuida.png)

#### Calculo de taxa, alugar e devolver filmes e listar alugados  

O sistema permite fazer o calculo da taxa de aluguel de um filme, dependendo da quantidade de dias.  

![Exemplo calculo taxa de aluguel](https://github.com/pauloszuparits/Imagens/blob/97fcd78b973964c66e55e1d89fa7fafbdceeaba7/imgLocadoraDistribuida/CalculoTaxaLocadoraDistribuida.png)  

Outra funcionalidade é de alugar e devolver um filme, onde será vinculado um cliente a este aluguel.
![Exemplo aluguel de filme](https://github.com/pauloszuparits/Imagens/blob/97fcd78b973964c66e55e1d89fa7fafbdceeaba7/imgLocadoraDistribuida/AluguelFilmeLocadoraDistribuida.png)  

Por fim, temos a funcionalidade de listar os filmes alugados  
![Exemplo Listagem filmes alugados](https://github.com/pauloszuparits/Imagens/blob/97fcd78b973964c66e55e1d89fa7fafbdceeaba7/imgLocadoraDistribuida/ListagemFilmesAlugadosLocadoraDistribuida.png)  

## Documentação técnica  

### Classes  

#### Conexao  

A classe conexao tem como objetivo fazer a conexão entre cliente e servidor. Essa classe possue 2 métodos estáticos, sendo eles: 
send -> recebe um socket e um objeto, e tem como objetivo enviar-lo.  
receive -> recebe um socket, e tem como objetivo receber um objeto.  

![Classe conexao](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/Conexao.png)  

#### Servidor  

A classe servidor possui diversas funcionalidades. Logo de inicio, a classe inicia os sockets.  

![Sockets Servidor](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/InicioSocketsServidor.png)  

A classe possui um método main que irá realizar todas as funcionalidades da classe servidor. Primieramente são instanciados alguns ArrayList que funcionam como banco de dados não relacionais, após isso, é instanciado um MsgReq e MsgResp, que serão as classes de requisição e resposta.  

![Instanciação Servidor](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/Instanciacao_Servidor.png)  

![connect servidor](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/Metodos/connect(),%20Servidor.png)  

Caso o servidor tenha se conectado através da funcao connect(), ele recebe uma requisição do cliente indicando qual será a função que o servidor irá efeturar.  

- 0 -> Cadastrar usuário
- 1 -> Cadastrar filme  
- 2 -> Buscar usuário  
- 3 -> Buscar filme  
- 4 -> Listar clientes  
- 5 -> Listar filmes  
- 6 -> Remover cliente  
- 7 -> Removerr filme  
- 8 -> Calcular taxa  
- 9 -> Calcular multa  
- 10 -> Alugar filme  
- 11 -> Devolver filme 
- 12 -> Listar filmes alugados
- 99 -> Desligar servidor

![Exemplo funcionalidade cadastrar usuário e filme servidor](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/Metodos/cadastrarUsuarioFilmeServidor.png)  

#### Cliente  

A classe cliente é responsável por pegar as entradas do usuário e se comunicar com o servidor para que ele faça o devido processamento destas entradas. Logo de inicio, a classe cliente inicia os sockets:  

![Inicio Socket Cliente](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/InicioSocketCliente.png)  

A classe possue um método main que irá realizar todas as funcionalidades. Primeiramente são instanciados um MsgReq e MsgResp, que serão as classes de requisição e resposta e um Scanner que irá fazer a entrada de dados. 

![Instanciação Cliente](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/InstanciacaoCliente.png)

Após isso começa a entrada de dados, que serão enviados ao servidor  

![Exemplo Cadastrar Usuario e Filme Cliente](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/Metodos/CadastraUsuarioFilmeCliente.png)  

#### Usuario  

A classe usuáio possui 5 parametros, sendo eles:
- String nome;
- String sobrenome;
- String cpf;
- int idade;
- int id;  

E um construtor que recebe um nome, um sobrenome, um cpf, uma idade e um id.  

![Construtor classe Usuario](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/Construtores/ConstrutorUsuario.png)  

##### Métodos

A classe possue "gets e sets" para todos os parametros.
Também possue um "método mágico" toString().  

![toString Usuario](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/Metodos/toStringUsuario.png)  

#### Filme  

A classe filme possue 5 parametros, sendo eles:  
- String nome;
- String genero;
- int ano;
- boolean alugado = false;
- int id;  

E um construtor que recebe um nome, um genero, um ano e um id.  

![Construtor classe Filme](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/Construtores/ConstrutorFilme.png)  

##### Métodos  

A classe possue "gets e sets" para todos os parametros.
Também possue 2 métodos, sendo eles um método mágico toString() e o outro um alugar, que muda o estado da variavel alugado.  

![Métodos da classe Filme](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/Metodos/MetodosFilme.png)  

#### Alugado  

A classe Alugado possue 2 parametros, sendo eles:  
- int idFilme;
- int idUsuario;

E um construtor que ecebe um idFilme e um idUsuario.

![Construtor classe Alugado](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/Construtores/ConstrutorAlugado.png)  

##### Métodos  
A classe possue "gets e sets" para todos os parametros.  

#### MsgReq  

A classe MsgReq é utilizada para fazer uma requisição do cliente para o servidor. Então a classe possue diversos parametros e diversos construtores. Cada construtor pode auxiliar em uma ou mais funções do servidor.   

![Parametros MsgReq](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/parametrosMsgReq.png)  

![Construtores MsgReq](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/Construtores/ConstrutoresMsgReq.png)
![Construtores MsgReq2](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/Construtores/ConstrutoresMsgReq2.png)  

#### MsgResp  

A classe MsgResp é utilizada para enviar uma resposta do servidor ao cliente. A classe possue 2 parametros, sendo eles:  
- int status;
- String resposta;  

E 3 construtores, um deles não recebe parametros, o outro recebe apenas um status e o ultimo recebe um status e uma resposta.  

![Construtores classe MsgResp](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/Construtores/ConstruotresMsgResp.png)  

### Protocolo e Lista de Status  

![Protocolo](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/Protocolo.png)  

![Lista de Status](https://github.com/pauloszuparits/Imagens/blob/9b6cee914d80b5970618951b4b0e821e2d485b27/DocTecnicaLocadoraDistrib/Status.png)


