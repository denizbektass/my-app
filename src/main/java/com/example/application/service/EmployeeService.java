package com.example.application.service;

import com.example.application.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    public List<Employee> getEmployeeList() {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("16345678001", "Ahmet", "Yıldırım"));
        employeeList.add(new Employee("12454789011", "Deniz", "Demirler"));
        employeeList.add(new Employee("85567870143", "Mustafa", "Aslan"));
        employeeList.add(new Employee("25675971214", "Nisa", "Aydın"));
        employeeList.add(new Employee("46786010325", "Sevgi", "Bektaş"));
        employeeList.add(new Employee("37590173453", "Mustafa", "Öztürk"));
        employeeList.add(new Employee("78921234560", "Nisa", "Aydın"));
        employeeList.add(new Employee("87012395270", "Deniz", "Kızılcık"));
        employeeList.add(new Employee("60125556719", "Ahmet", "Güneş"));
        employeeList.add(new Employee("94274267898", "Ahmet", "Eren"));

        return employeeList;
    }
}
