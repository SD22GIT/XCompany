package com.crio.xcompany.company.DataBaseImpl;

import java.util.HashMap;
import com.crio.xcompany.company.IDataBase.IDatabase;
import com.crio.xcompany.company.Employee;

public class HashMapDatabase implements IDatabase {

    private static HashMap<String,Employee> database = new HashMap<>();
    
    @Override
    public void save(Employee employee)
    {
        database.put(employee.getName(), employee);
    }

    @Override
    public void delete(String employeeName)
    {
        if(database.containsKey(employeeName))
        {
        database.remove(employeeName);
        }
    }

    @Override
    public Employee get(String name)
    {
        return database.get(name);
    }
    
}
