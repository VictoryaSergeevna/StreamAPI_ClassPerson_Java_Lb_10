package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    private static List<Person> persons = new ArrayList<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Person person1 = new Person( "Ivan", 23);
        Person person2 = new Person( "Olga", 45);
        Person person3 = new Person( "John", 12);
        Person person4 = new Person( "Vitaliy", 25);
        Person person5 = new Person( "Vika", 35);
        Person person6 = new Person( "Veronika", 35);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);
        getPersonsByName("V");
        getGroupByAge();
        System.out.println(getPersonsAverage());
        getAge();

    }
//    1) Выведите список людей, у которых имя начинается с определенной буквы.
public static void getPersonsByName(String letter) {
    System.out.println("1. Cписок людей, у которых имя начинается с определенной буквы: ");
    persons.stream().filter((p) -> p.getName().startsWith(letter)).forEach(p-> System.out.println(p.toString()));

}
//2) Сгруппируйте и выведите данные обо всех людях в виде таблицы.
public static void getGroupByAge(){
    System.out.println("2. Сгруппируйте и выведите данные обо всех людях в виде таблицы");
    Map<Integer, Set<String>> map = persons.stream()
            .collect(Collectors.groupingBy(Person::getAge,
                    Collectors.mapping(Person::getName, Collectors.toSet())));
    for(Map.Entry<Integer, Set<String>> item : map.entrySet()){

        System.out.println("age "+ item.getKey() + " : " + item.getValue());
    }

}
//3) Выведите средний возраст всех людей из списка.
public static double getPersonsAverage() {
    System.out.println("3. Cредний возраст всех людей из списка:");
    return persons.stream().mapToInt(Person::getAge).average().getAsDouble();
}

    public static void getAge(){
        System.out.println("4. Выведите всех людей, возраст которых больше или равен 18, при этом добавив к выводу текст:");
        String name=persons.stream().filter((p) -> p.getAge() >= 18).map(x->x.getName()).collect(Collectors.joining(" и "));
        System.out.println("В Украине "+name+" достигли совершенолетия");
    }
}
