package com.example.demo;
import com.example.demo.models.Emloyes;
import com.example.demo.models.OtherData;
import com.example.demo.models.PersonalData;
import com.example.demo.models.WorkBook;
import com.example.demo.models.PerformanceEvaluatuionAndFeedback;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Readfile {
    public static void main(String[]args) {
        String hello  = read().toString();
        System.out.println(hello);
    }

    public static List<Emloyes> read() {
        String fileName = "file.txt";
        File file = new File(fileName);
        List<Emloyes> employees = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] elements = line.split(",");
                String id = elements[0];
                OtherData otherData = new OtherData(elements[0], elements[2]);
                PerformanceEvaluatuionAndFeedback performanceEvaluationAndFeedback = new PerformanceEvaluatuionAndFeedback(elements[3], elements[4]);
                WorkBook workBook = new WorkBook(elements[5], elements[6], elements[7]);
                PersonalData personalData = new PersonalData(elements[8], elements[9], elements[10]);
                Emloyes employee = new Emloyes(id, otherData, performanceEvaluationAndFeedback, workBook, personalData);
                employees.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }
}