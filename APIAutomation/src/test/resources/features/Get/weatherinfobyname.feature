Feature: Listar info clima por ciudad
  Como usuario de la API
  Quiero poder visualizar la informacion
  climatica de una ciudad mediante su nombre

  @Positive
  Scenario Outline: Obtener la info del clima exitosa
    Given url 'https://api.openweathermap.org/data/2.5/weather?q=<city>&appid=<apikey>'
    And headers { Accept: 'application/json' }
    When method get
    Then status 200
    And match response contains {name: <city>, coord: #notnull, weather: #notnull}
    And match responseHeaders['Content-Type'] contains ['application/json; charset=utf-8']


    Examples:
      | city    | apikey                                 |
      | London  | ac499fcdcfd3dd12d460372ca1a8e05a       |
      | Paris   | ac499fcdcfd3dd12d460372ca1a8e05a       |
      | Berlin  | ac499fcdcfd3dd12d460372ca1a8e05a       |

  @Negative
  Scenario Outline: Obtener la info del clima fallida - Clave API incorrecta
    Given url 'https://api.openweathermap.org/data/2.5/weather?q=<city>&appid=<apikey>'
    When method get
    Then status 401
    And match response == { "cod": 401, "message": "Invalid API key. Please see https://openweathermap.org/faq#error401 for more info." }

    Examples:
      | city    | apikey                 |
      | London  | ac499fcdcfd3dd12       |
      | Paris   | d460372ca1a8e05a       |
      | Berlin  | 6565372ca1a8e05a       |