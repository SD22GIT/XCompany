package com.crio.xcompany.company.IDataBase;

import com.crio.xcompany.company.Employee;

public interface IDatabase {

    public void save(Employee employee);
    public void delete(String employee);
    public Employee get(String name);
    
}
