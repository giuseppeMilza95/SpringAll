package practiceactivity8.practiceactivity8.main;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.annotation.Configurations;
import practiceactivity8.practiceactivity8.model.Employee;

import java.util.List;


public class CrudEmployeeMain {
        private SessionFactory factory;
        private Session session;

    public CrudEmployeeMain() {
        this.factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        this.session = factory.getCurrentSession();
    }

    public static void main(String[] args) {

        //Create a session
        CrudEmployeeMain crudEmployeeMain = new CrudEmployeeMain();

        try{
            crudEmployeeMain.getSession().beginTransaction();
            crudEmployeeMain.addEmployee(new Employee("Giuseppe", "Tumminello", "State Street"));
            crudEmployeeMain.addEmployee(new Employee("Giovanni", "Tumminello", "DXC Technology"));
            crudEmployeeMain.addEmployee(new Employee("Agata", "Miedzinska", "Swarovski"));
            crudEmployeeMain.retrieveEmployeeByPrimaryKey(new Employee("Giuseppe", "Tumminello", "State Street"));
            crudEmployeeMain.retrieveEmployeeByCompany("State Street");
            crudEmployeeMain.deleteEmployee(1);
            crudEmployeeMain.getSession().getTransaction().commit();




        }catch(Exception e){
            e.printStackTrace();

        }finally {
            System.out.println("Closing the session");
            crudEmployeeMain.factory.close();
        }
    }


    public void addEmployee(Employee employee){
        try{

            System.out.println("Adding the Employee inside the database");
            getSession().save(employee);
            System.out.println("The Employee has been saved successfully");



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void retrieveEmployeeByCompany(String company){


        List<Employee> employeeList = getSession().createQuery("from Employee where company='"+ company +"'").getResultList();
        System.out.println("Printing out the list of employee: ");
        for (Employee employee : employeeList){
            System.out.println(employee);
        }

    }

    public void retrieveEmployeeByPrimaryKey(Employee employee){


       Employee employeeByPrimaryKey = getSession().get(Employee.class,employee.getId());
        System.out.println("The employee by primary key: ");
        System.out.println(employeeByPrimaryKey);


    }




    public void deleteEmployee(int primaryKey){

        System.out.println("Deleting the Employee from the table.....");
        Employee tempStudent = getSession().get(Employee.class, primaryKey);
        session.delete(tempStudent);
        System.out.println("The employee has been deleted successfully");
    }

    public Session getSession() {
        return session;
    }
}
