# language: pt
Funcionalidade: Comprar passagem aérea
  Escolher e comprar uma passagem aereas

  Cenario: Comprar com sucesso
    Dado que acesso o site "https://blazedemo.com/"
    Quando seleciono a origem "São Paolo" e destino "Cairo"
    E clico no botao Find Flights
    Entao visualiza a lista de voos

  Esquema do Cenario: Comprar com sucesso DDT
    Dado que acesso o site "https://blazedemo.com/"
    Quando seleciono a "<origem>" e "<destino>"
    E clico no botao Find Flights
    Entao visualiza a lista de voos

    Exemplos:
      | origem    | destino |
      | São Paolo | Cairo   |
      | Boston    | London  |
#Quando houver um OU é melhor separar em 2 ou mais cenario 
# Cenario: Cadastrar Cliente
#   Dado que acesso a pagina de cadastro de cliente
#    Entao escolho entre PF ou PJ
#    E preencho os dados cadastrais
#    Quando cliclo em salvar
#    Entao visualiza a mensagem de sucesso
#  Cenario: Cadastrar Cliente PF
#    Dado que acesso a pagina de cadastro de cliente
#    Entao escolho o tipo "PF"
#    E preencho o Nome, CPF e data de nascimento
#    E preencho os telefones e o email
#    Quando cliclo em salvar
#    Entao visualiza a mensagem de sucesso
#  Cenario: Cadastrar Cliente PJ
#    Dado que acesso a pagina de cadastro de cliente
#    Entao escolho o tipo "PJ"
#    E preencho o Razao Social, CNPJ e data de fundacao
#    E preencho os telefones e o email
#    Quando cliclo em salvar
#    Entao visualiza a mensagem de sucesso
#Testes Negativos

  Esquema do Cenario: Login Positivo
    Dado acesso a pagina  de Login
    Quando preencho o <"email"> e a <"senha">
    E clico no botao Login
    Entao visualiza a mensagem de sucesso

  Exemplos:
    | email             | senha  |
    | cliente@gmail.com | 123456 |

  Esquema do Cenario: Login Negativo
    Dado acesso a pagina  de Login
    Quando preencho o <"email"> e a <"senha">
    E clico no botao Login
    Entao visualiza a mensagem de email ou senha incorretos
  Exemplos:
  | email              | senha  |
  | begas@gmail.com    | 12345  |
  | aluno@gmail.com    | 123456 |
  | cliente@gmail.com  | 000000 |

  Esquema do Cenario: Login 
    Dado acesso a pagina  de Login
    Quando preencho o <"email"> e a <"senha">
    E clico no botao Login
    Entao visualiza a <"mensagem">
  Exemplos:
    | email             | senha  | tipo | messagem                |
    | cliente@gmail.com | 123456 |P     |mensagem de sucesso      |
    | begas@gmail.com   | 12345  |N     |email ou senha incorretos|
    | aluno@gmail.com   | 123456 |N     |email ou senha incorretos|
    | cliente@gmail.com | 000000 |N     |email ou senha incorretos|

