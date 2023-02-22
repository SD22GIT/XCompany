package com.crio.xcompany.company;

import java.util.List;
import java.util.LinkedList;


public class Employee {
    private String name;
    private Gender gender;
    private Employee manager;
    private List<Employee> reportees;

    public Employee(String name, Gender gender) {
        this.name=name;
        this.gender=gender;
        this.manager=null;
        this.reportees = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    // TODO: CRIO_TASK_MODULE_XCOMPANY
    // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone before implementing the logic.
    // This will ensure that the project can be compiled successfully.

    public Employee getManager()
    {
       return this.manager;
    }

    public List getDirectReports()
    {
        return this.reportees;
    }

    public void assignManager(Employee employee)
    {
        this.manager = employee;
        this.manager.addReportee(this);
    }

    public void addReportee(Employee employee)
    {
        reportees.add(employee);
    }

    public List getTeamMates()
    {
      List<Employee> teamMates = new LinkedList<>();
      if(this.manager==null)
      {
        teamMates.addAll(this.getDirectReports());
      }
      else
      {
      teamMates.add(this.manager);
      teamMates.addAll(this.manager.getDirectReports());
      }
      return teamMates;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", gender=" + gender + "]";
    }   
}
