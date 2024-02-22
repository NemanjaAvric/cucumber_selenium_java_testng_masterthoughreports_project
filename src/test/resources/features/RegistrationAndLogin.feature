Feature: Registration and Login scenarios

  Scenario Outline: Register to Automation Exercise web app and logout
    Given I am on the Home Page
    When I Sign up using '<username>' as username and '<email>' as email
    And Create an account using following data: '<title>', '<name>', '<password>', <day>, '<month>', <year>, '<firstName>', '<lastName>', '<company>', '<adress1>', '<adress2>', '<country>', '<state>', '<city>' <zipcode>, '<mobilenumber>'
    And Verify that account is created and that I'm logged in
    Then Logout

    Examples:
      | username   | email                    | title | name     | password                | day | month     | year | firstName | lastName   | company                   | adress1                                                       | adress2                                                           | country       | state      | city        | zipcode | mobilenumber |
      | AtInkeR    | joyek92095@huizk.com     | Mr.   | Okarin   | elPsyCongroo@75         | 14  | December  | 1995 | Okabe     | Rintarou   | SteinsGate                | Suite 557 358 Wisoky Village, OKeefeborough, AZ 88112-7651    | Suite 670 90520 Maudie Stream, Kathrineburgh, CA 51642            | India         | New Delhi  | New Delhi   | 18955   | +14238775659 |
      | HoRMemp    | zizek91115@gmail.com     | Mr.   | Thorfinn | GOTOVINLAND998!!!!      | 3   | February  | 1900 | Thorfinn  | Karlsefnni | Vinland                   | 141 Kamala Plains, Runolfssonport, DE 23389-8849              | Diekplantsoen 380a, Dammissluis, FL 6332 TS                       | United States | Montana    | Livingstone | 28761   | +12722233178 |
      | TAIlSODGEn | tigeyey834@lendfash.com  | Mr.   | Levi     | LeviIsSHORT321          | 25  | November  | 1914 | Levi      | Ackerman   | SurveyCorps               | Zimmer 735 Pfarrer-Klein-Str. 40a, Leroyheim, HB 42840        | Suite 833 ul. Maciąg 40534, Myślenice, OP 97-724                  | Canada        | Quebec     | Quebec      | 75480   | +13139364157 |
      | HeNThQUIT  | pexes84838@ebuthor.com   | Mrs.  | Sophie   | hEaRts_A_hEaVy_BuRdEN<3 | 17  | April     | 1976 | Sophie    | Hatter     | HowlsMovingCastle         | Suite 279 7220 Keeling Hills, Mayerville, MN 16416-7932       |                                                                   | Australia     | Victoria   | Melbourne   | 82729   | +12142864429 |
      | onsFIckRuN | 6naxofim42@hotmail.com   | Mrs.  | Mayushi  | tuTUtUUURuuuuu...       | 21  | January   | 2021 | Mayuri    | Shiina     | SteingGate                | Sjuulkelaan 764a, Oost Hopmansdijk, TN 4548 EF                |                                                                   | Israel        | Tel Aviv   | Tel Aviv    | 61331   | +16058618086 |
      | SPHOWEiNde | 3295yaheki@yahoo.com     | Mrs.  | Ymir     | @#Tatakae91#@@@         | 31  | March     | 1901 | Ymir      | Fritz      | Eldia Empire              | Explanada Alicia Briseño 8 Puerta 240, Fuenlabrada, Mad 85653 | Esc. 926 Grupo Juan Carlos s/n., Coslada, Leo 34216               | New Zealand   | Wellington | Wellington  | 93291   | +15177274646 |
      | coMBeD     | fiharag806@gexige.com    | Mrs.  | Historia | SasageyoSasageyo        | 1   | August    | 2020 | Historia  | Reiss      | Paradise Island           | Apt. 864, 29 Villa Auguste Renoir, 87571 Épinay-sur-Seine     | Piano 5 Borgo Mazza 361, Piano 8, Borgo Penelope veneto, TS 94771 | Singapore     | Singapore  | Singapore   | 98148   | +14796626615 |
      | UcurBanDe  | kineh96699@gexige.com    | Mr.   | Todo     | TakadaItadori<3<3<3     | 30  | September | 1984 | Aoi       | Todo       | Kyoto Jujutsu High School | Jl. Kartini No. 15, Sawah Lunto, AC 82170                     |                                                                   | United States | New York   | New York    | 24401   | +13044490202 |
      | MAkise     | makisekurisu96@gmail.com | Mrs.  | Makise   | Amadeus6:5:6            | 6   | July      | 1996 | Makise    | Kurisu     | Amadeus Project           | 733 Ofélia Marginal, Rebordosa, WI 1110                       | Entrada Caridad Salazar 1 Puerta 763, Valladolid, And 36265       | Canada        | Montreal   | Montreal    | 690     | +13199019820 |


  Scenario Outline: Login with valid credentials and logout
    Given I am on the Home Page
    When I login with valid email: '<email>' and valid password: '<password>'
    And Verify that I'm logged in
    Then Logout


    Examples:
      | email                    | password                |
      | joyek92095@huizk.com     | elPsyCongroo@75         |
      | zizek91115@gmail.com     | GOTOVINLAND998!!!!      |
      | tigeyey834@lendfash.com  | LeviIsSHORT321          |
      | pexes84838@ebuthor.com   | hEaRts_A_hEaVy_BuRdEN<3 |
      | 6naxofim42@hotmail.com   | tuTUtUUURuuuuu...       |
      | 3295yaheki@yahoo.com     | @#Tatakae91#@@@         |
      | fiharag806@gexige.com    | SasageyoSasageyo        |
      | kineh96699@gexige.com    | TakadaItadori<3<3<3     |
      | makisekurisu96@gmail.com | Amadeus6:5:6            |

  Scenario Outline: Login with valid credentials and delete the account
    Given I am on the Home Page
    When I login with valid email: '<email>' and valid password: '<password>'
    And Verify that I'm logged in
    Then Delete the account


    Examples:
      | email                    | password                |
      | joyek92095@huizk.com     | elPsyCongroo@75         |
      | zizek91115@gmail.com     | GOTOVINLAND998!!!!      |
      | tigeyey834@lendfash.com  | LeviIsSHORT321          |
      | pexes84838@ebuthor.com   | hEaRts_A_hEaVy_BuRdEN<3 |
      | 6naxofim42@hotmail.com   | tuTUtUUURuuuuu...       |
      | 3295yaheki@yahoo.com     | @#Tatakae91#@@@         |
      | fiharag806@gexige.com    | SasageyoSasageyo        |
      | kineh96699@gexige.com    | TakadaItadori<3<3<3     |
      | makisekurisu96@gmail.com | Amadeus6:5:6            |




