


// class for methods
public class TravelCurrencyConverter{

    // methods to convert currencies
    public double convertUserInput(double userInput, int destination){
        double convertedValue = 0;
        switch(destination){
            case 1:
                convertedValue = userInput * 379.28;//Niara
                break;
            case 2:
                convertedValue = userInput * 116.92;//rupees
                break;
            case 3:
                convertedValue = userInput * 0.8316;//euros
                break;
            case 4:
                convertedValue = userInput * 108.29;//yen
                break;
            case 5:
                convertedValue = userInput * 0.7130;//GBP
                break;
            case 6:
                convertedValue = userInput * 1.2086;//cs
                break;
        }
        return convertedValue;
    }



    // method to convert from countries to number
    public int convertCountry(String country){
        int num = 0;
        switch (country){
            case "Nigeria":
                num = 1;
                break;

            case "Nepal":
                num = 2;
                break;

            case "Spain":
                num = 3;
                break;

            case "Japan":
                num = 4;
                break;

            case "England":
                num = 5;
                break;

            case "Canada":
                num = 6;
                break;
        }
        return num;
    }

    //stores the languages spoken in each country in a string
    public String[] language(String country){
        String[] languages = {};
        switch (country){
            case "Nigeria":
                languages = new String[]{"English", "Igbo", "Yoruba", "Hausa"};
                break;

            case "Nepal":
                languages = new String[]{"Nepali", "English"};
                break;

            case "Spain":
                languages = new String[]{"Spanish","English"};
                break;

            case "Japan":
                languages = new String[]{"Japanese", "English"};
                break;

            case "England":
                languages = new String[]{"English"};
                break;

            case "Canada":
                languages = new String[]{"English", "French"};
                break;

        }
        return languages;
    }

    // return the message in the language chosen by the user.
    public String message(double userInput, String country, String language){
        String message = "";
        int convertCountry = convertCountry(country);
        switch (convertCountry){
            case 1:
                if(language.equals("English"))
                {message = "\n" +
                        "The converted value is ₦" + convertUserInput(userInput, convertCountry(country)) + ".";}

                if(language.equals("Yoruba"))
                {message = "\nIye iyipada jẹ ₦" + convertUserInput(userInput, convertCountry(country)) + ".";}

                if(language.equals("Igbo"))
                {message = "\nUru agbanwere bụ ₦" + convertUserInput(userInput, convertCountry(country)) + ".";}

                if(language.equals("Hausa"))
                {message = "\nConvertedimar da aka canza ita ce ₦" + convertUserInput(userInput, convertCountry(country)) + ".";}
                break;

            case 2:
                if(language.equals("English"))
                {message = "\nThe converted value is ₹" + convertUserInput(userInput, convertCountry(country)) + ".";}
                if(language.equals("Nepali"))
                {message = "\n" +
                        "Rūpāntarita māna hō ₹" + convertUserInput(userInput, convertCountry(country)) + ".";}
                break;

            case 3:
                if(language.equals("English"))
                {message = "\nThe converted value is €" + convertUserInput(userInput, convertCountry(country)) + ".";}

                if(language.equals("Spanish"))
                {message = "\nEl valor convertido es €" + convertUserInput(userInput, convertCountry(country)) + ".";}
                break;

            case 4:
                if(language.equals("English"))
                {message = "\nThe converted value is ¥" + convertUserInput(userInput, convertCountry(country)) + ".";}

                if(language.equals("Japanese"))
                {message = "\n変換された値は ¥" + convertUserInput(userInput, convertCountry(country)) + ".";}
                break;

            case 5:
                if(language.equals("English"))
                {message = "\nThe converted value is £" + convertUserInput(userInput, convertCountry(country)) + ".";}
                break;

            case 6:
                if(language.equals("English"))
                {message = "\nThe converted value is C$" + convertUserInput(userInput, convertCountry(country)) + ".";}

                if(language.equals("French"))
                {message = "\nLa valeur convertie est C$" + convertUserInput(userInput, convertCountry(country)) + ".";}


        }
        return message;
    }
}










