package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomNumber {

    private String number = "";

    public RandomNumber(){
        List<Character> digitals = new ArrayList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        Random random = new Random();
        Character randomDigital;
        for (int i = 0; i < 4; ++i) {
            randomDigital = digitals.get(random.nextInt(digitals.size()));
            for(int j = 0;j<digitals.size();++j) {
                if(randomDigital.compareTo(digitals.get(j)) == 0){
                    digitals.remove(j);
                    break;
                }
            }
            number+=randomDigital.toString();
        }
    }

    public String getNumber(){
        return number;
    }
}
