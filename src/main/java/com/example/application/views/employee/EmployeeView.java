package com.example.application.views.employee;

import com.example.application.model.Employee;
import com.example.application.service.EmployeeService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Employee")
@Route(value = "employee", layout = MainLayout.class)
public class EmployeeView extends VerticalLayout {
    private final EmployeeService employeeService;
    private final Grid<Employee> grid;
    private final TextField searchField;
    private final ListDataProvider<Employee> dataProvider;

    @Autowired
    public EmployeeView(EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.grid = new Grid<>(Employee.class);
        this.searchField = new TextField();
        this.dataProvider = new ListDataProvider<>(employeeService.getEmployeeList());

        configureSearchField();
        configureGrid();

        add(searchField, grid);
    }
    private void configureSearchField() {
        searchField.setPlaceholder("Search by name...");
        searchField.setValueChangeMode(ValueChangeMode.EAGER);
        searchField.addValueChangeListener(e -> updateFilter());
    }
    private void configureGrid() {
        grid.setDataProvider(dataProvider);
        grid.setColumns("name", "surname");
    }
    private void updateFilter() {
        String filterText = searchField.getValue().trim();

        dataProvider.setFilter(employee -> {
            if (filterText.isEmpty()) {
                return true;
            }
            String lowerCaseFilterText = filterText.toLowerCase();
            boolean matchesName = employee.getName().toLowerCase().contains(lowerCaseFilterText);

            return matchesName;
        });
    }
}
