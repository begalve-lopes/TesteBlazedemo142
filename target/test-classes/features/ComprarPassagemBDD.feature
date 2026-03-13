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