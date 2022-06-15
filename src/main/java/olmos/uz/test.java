package olmos.uz;

import olmos.uz.springboot.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class test {
    static List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1,"Jahongir","Yoldoshev", new Date(),"+998991101193"),
            new Student(2,"Javoxir","Alisherov", new Date(),"+998991101193"),
            new Student(3,"Atham","Alijonov", new Date(),"+998991101198"),
            new Student(4,"Alisher","Karimov", new Date(),"+998991101192")
    ));

    public static String test(){
        boolean b=true;
        for (int i = 0; i < students.size(); i++) {
            for (int j = students.size()-1; j > 0; j--) {
                if (i!=j){
                    if (students.get(i).getPhoneNumber() == students.get(j).getPhoneNumber()){
                        b=false;
                        break;
                    }
                }
            }
        }
        if (b){
            return "added to Students List";
        }
        else {
            return "Enter new phoneNumber";
        }
    }
    public static void main(String[] args) {
        System.out.println(students.get(students.size()-1).getId()+1);
        String s= test();
        System.out.println(s);

    }
}
