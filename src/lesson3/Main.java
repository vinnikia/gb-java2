package lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся)
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Лион");
        cities.add("Лиссабон");
        cities.add("Лион");
        cities.add("Москва");
        cities.add("Лион");
        cities.add("Вашингтон");
        cities.add("Москва");
        cities.add("Гамбург");
        cities.add("Марсель");
        cities.add("Брест");
        cities.add("Минск");
        cities.add("Пенза");
        cities.add("Белгород");
        cities.add("Мадрид");
        cities.add("Берлин");
        cities.add("Варшава");
        cities.add("Гамбург");
        cities.add("Вашингтон");
        cities.add("Йоханнесбург");
        cities.add("Ганновер");
        cities.add("Амстердам");
        cities.add("Коппенгаген");
        cities.add("Коломбо");
        cities.add("Сидней");
        cities.add("Бразилиа");

        System.out.println("Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем)");
        TreeSet<String> uniqueCities = new TreeSet<>(cities);
        System.out.println(uniqueCities);

        Map<String, Integer> countCities = new TreeMap<>();
        for (String city : cities) {

            Integer times = countCities.get(city);
            times = (times == null) ?  1 : times+1;

            countCities.put(city, times);
        }
        System.out.println("Посчитать сколько раз встречается каждое слово");
        System.out.println(countCities);


        Phonebook phb = new Phonebook();
        phb.add("Жирков", "+79802654545");
        phb.add("Соболев", "+79806980202");
        phb.add("Дроздов", "+79102741298");
        phb.add("Жирков", "+79202154412");

        System.out.println("Телефоны Жиркова:");
        phb.get("Жирков");
        System.out.println("Телефоны Соболева");
        phb.get("Соболев");

    }
}
