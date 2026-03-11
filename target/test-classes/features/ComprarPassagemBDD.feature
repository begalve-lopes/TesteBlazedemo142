# language: pt
Funcionalidade: Comprar passagem aérea
    Escolher e comprar uma passagem aereas

  Cenario: Comprar com sucessso
    Dado que acesso o site "https://blazedemo.com/"
    Quando seleciono a origem "São Paolo" e destino "Cairo"
    E clico no botao Find Flights
    Entao visualiza a lista de voos
