package com.crio.xcompany.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.Queue;
import com.crio.xcompany.company.IDataBase.IDatabase;
import com.crio.xcompany.company.DataBaseImpl.HashMapDatabase;

public class Company{
    private String companyName;
    private Employee founder;
    private Map<String,Employee> employeeBook;
    

    private Company(String companyName, Employee founder) {
        this.companyName = companyName;
        this.founder = founder;
        employeeBook = new HashMap<String,Employee>();
        employeeBook.put(founder.getName(), founder);
    }
    

    public static Company create(String companyName, Employee founder){
        return new Company(companyName,founder);
    } 


    public String getCompanyName() {
        return companyName;
    }

    // TODO: CRIO_TASK_MODULE_XCOMPANY
    // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone for each functionality before implementing the logic.
    // This will ensure that the project can be compiled successfully.
    public void registerEmployee(String employeeName, Gender gender)
    {
       Employee employee = new Employee(employeeName,gender);
        IDatabase hashMapDatabase = new HashMapDatabase();
      hashMapDatabase.save(employee);
    }

    public Employee getEmployee(String employeeName)
    {
        IDatabase hashMapDatabase = new HashMapDatabase();
        return hashMapDatabase.get(employeeName);
    }

    public void deleteEmployee(String employeeName)
    {
        IDatabase hashMapDatabase = new HashMapDatabase();
        Employee employee =  hashMapDatabase.get(employeeName);
        hashMapDatabase.delete(employeeName);
        employee=null;
    }

    public void assignManager(String employeeName,String managerName)
    {
        IDatabase hashMapDatabase = new HashMapDatabase();
        Employee employee = hashMapDatabase.get(employeeName);
        Employee manager = hashMapDatabase.get(managerName);
        employee.assignManager(manager);

    }

    public List getDirectReports(String managerName)
    {
        IDatabase hashMapDatabase = new HashMapDatabase();
        Employee employee = hashMapDatabase.get(managerName);
        return employee.getDirectReports();
    }

    public List getTeamMates(String employeeName)
    {
        IDatabase hashMapDatabase = new HashMapDatabase();
        Employee employee = hashMapDatabase.get(employeeName);
        return employee.getTeamMates();
    }

    public List<List<Employee>> getEmployeeHierarchy(String managerName)
    {
        Queue<Employee> queue = new LinkedList<>();
        List<List<Employee>> hierarchy = new LinkedList<>();
        List<Employee> reportees;
        IDatabase hashMapDatabase = new HashMapDatabase();
        Employee employee = hashMapDatabase.get(managerName);
        queue.add(employee);

        while(queue.size()>0)
        {
            int current=queue.size();
            reportees=new LinkedList<>();
            while(current>0)
            {
                Employee temp = queue.poll();
                reportees.add(temp);
                if(temp!=null)
                {
                queue.addAll(temp.getDirectReports());
                }
                --current;                
            }
            hierarchy.add(reportees);
        }

        return hierarchy;
    }



}
