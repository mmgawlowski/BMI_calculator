def BMI_calculator():

    print('Jak masz na imię?')
    my_name = input()

    print('Witaj ' + my_name + '. Jaki jest Twój wzrost w m (np. 1.62)?')
    my_height = input()

    while True:
        if ',' in my_height:
            print('Podaj wzrost używając "."')
            my_height = input()
            continue
        try: val = float(my_height)
        except ValueError:
            print('Nieprawidłowa wartość. Podaj swój prawidłowy wzrost w m.')
            my_height = input()
            continue
        if 0 > Decimal(my_height) or 3 < Decimal(my_height):
            print('Nieprawidłowa wartość. Podaj swój prawidłowy wzrost w m.')
            my_height = input()
        else:
            break

    print('Dobrze, jaka jest Twoja waga w kg?')
    my_weight = input()

    while True:
        if ',' in my_weight:
            print('Podaj wagę używając "."')
            my_weight = input()
            continue
        try: val = float(my_weight)
        except ValueError:
            print('Nieprawidłowa wartość. Podaj swoją prawidłową wagę w kg.')
            my_weight = input()
            continue
        if 0 > Decimal(my_weight):
            print('Nieprawidłowa wartość. Podaj swoją prawidłową wagę w kg.')
            my_weight = input()    
        else:
            break 

    BMI = Decimal(my_weight)/Decimal(my_height)**2
    print('Twoje BMI wynosi: ' + str(BMI))

    def BMI_comment(BMI):
        if 0 < BMI < 16:
            return 'wygłodzenie'
        elif 16 <= BMI <= 16.99:
            return 'wychudzenie'
        elif 17 <= BMI <= 18.49:
            return 'niedowagę'
        elif 18.5 <= BMI <= 24.99:
            return 'prawidłową wagę'
        elif 25 <= BMI <= 29.99:
            return 'nadwagę'
        elif 30 <= BMI <= 34.99:
            return 'I stopień otyłości'
        elif 35 <= BMI <= 39.99:
            return 'II stopień otyłości (otyłość kliniczna)'
        elif BMI >= 40.00:
            return 'III stopień otyłości (otyłość skrajna)'
        else:
            return 'wartość nieprawidłowa'

    print('Twoje BMI wskazuje na ' + BMI_comment(BMI))

while True:
    from decimal import *
    getcontext().prec = 4

    yes_list = ['tak', 't']
    no_list = ['nie', 'n']

    restart = input('\nCzy chcesz rozpocząć nową kalkulację? (t/n)').lower()

    if restart in yes_list:
        BMI_calculator()
    elif restart in no_list:
        break
    else:
        print('Wybierz t lub n')
        continue
quit()
