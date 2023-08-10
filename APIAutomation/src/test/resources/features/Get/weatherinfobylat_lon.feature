Feature: Listar info clima por latitud y longitud
  Como usuario de la API
  Quiero poder visualizar la informacion
  climatica de una ciudad mediante su ubicacion geografica

  @Positive
  Scenario Outline: Obtener la info del clima exitosa - Coordenadas correctas
    Given url 'https://api.openweathermap.org/data/2.5/weather?lat=<lat>&lon=<lon>&appid=<apikey>&mode=xml'
    And headers { Accept: 'application/xml' }
    When method get
    Then status 200
    And match response city/coord == '#present'
    And match response city/coord.lon == '#notnull'
    And match response city.name == '#notnull'

    Examples:
      | lat     | lon   | apikey                                 |
      | 44.34   | 10.99 | ac499fcdcfd3dd12d460372ca1a8e05a       |
      | 10      | 1     | ac499fcdcfd3dd12d460372ca1a8e05a       |
      | 11      | 2     | ac499fcdcfd3dd12d460372ca1a8e05a       |




















