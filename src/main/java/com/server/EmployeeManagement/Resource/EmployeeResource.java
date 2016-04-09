package com.server.EmployeeManagement.Resource;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



import com.server.EmployeeManagement.Model.Employee;
import com.server.EmployeeManagement.Service.EmployeeService;

@Path("employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
	EmployeeService service = new EmployeeService();
	
	@GET
	public ArrayList<Employee> getRequest(){
		return service.getEmployeeList();
	}
	
	@GET
	@Path("/{empid}")
	public Employee getEmpByID(@PathParam("empid") long id ){
		return service.getEmpByID(id);
	}
	@GET
	@Path("/emp")
	public Employee getEmpByIDQuery(@QueryParam("id") long  id  ){
		return service.getEmpByID(id);
	}

	@POST
	public Employee addEmployee(Employee emp){
		return service.addEmployee(emp);
	}
	
	@PUT
	@Path("/{empid}")
	public Employee modifyEmpData(@PathParam("empid") long id,Employee emp){
		System.out.println("id ---- "+id);
		return service.modifyEmployeeData(id, emp);
	}
	
	@DELETE
	@Path("/{empid}")
	public void deleteEmployee(@PathParam("empid") long id){
		service.deleteEmployee(id);
	}
	
	

}
